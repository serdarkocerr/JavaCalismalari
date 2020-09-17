package tr.com.siparis.sistemi;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tr.com.siparis.sistemi.consumer.KafkaReceiver;
import tr.com.siparis.sistemi.kafka.model.CRUDType;
import tr.com.siparis.sistemi.kafka.model.DKUserInfo;
import tr.com.siparis.sistemi.kafka.model.Siparis;
import tr.com.siparis.sistemi.kafka.model.SiparisCRUD;
import tr.com.siparis.sistemi.kafka.model.SiparisKafkaModel;
import tr.com.siparis.sistemi.producer.KafkaSender;
import tr.com.siparis.sistemi.securelogin.UserPrincipal;
import tr.com.siparis.sistemi.web.model.MesajPojo;
import tr.com.siparis.sistemi.web.model.WebSiparisModel;



@Controller
public class KafkaController {

	  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

	  
	@Autowired
	private KafkaSender sender;
	@Autowired
	private KafkaReceiver receiver;
	
	@Autowired
	private General general;
	
	@PostMapping(value = "siparis-ekle")
	public ModelAndView siparisEkle( @ModelAttribute("a1")WebSiparisModel siparis,@AuthenticationPrincipal final UserPrincipal user){//UserPrincipal bizim olusturdugumuz.
		LOGGER.debug("KafkaController.siparisEkle()");
		int kullaniciId;
		String currenUser = user.getUsername();
		String passw =  user.getPassword();
		DKUserInfo  userInfo = receiver.atomicDKUserInfoTable.get().getUserInfoTable().stream().filter(p->p.getKullaniciAdi().toString().equalsIgnoreCase(currenUser)).
				filter(k->k.getKullaniciSifre().toString().equalsIgnoreCase(passw)).collect(Collectors.toList()).get(0);
		if(currenUser.equalsIgnoreCase("admin")) {
			kullaniciId = 999;
		}else {
			kullaniciId = userInfo.getKullaniciID();
		}
		System.out.println("KafkaController.urunekle() siparis : " + siparis.toString());

		ModelAndView modelView = null;
		
		try {
			siparisCRUD(CRUD.CREATE,siparis,kullaniciId);//Siparis Ekle Kafkaya publish ediliyor.
			Thread.sleep(2000);//OSGI ugulamasından kafkada bulunan urunleri güncellemesini bekliyor.
			modelView = new ModelAndView();
			
			List<Siparis> siparisler = general.getSiparisler();
			modelView.addObject("siparisler", siparisler.stream().collect(Collectors.toList()));
			if(userInfo.getKullaniciTurAdi().toString().contains("Garson"))
				modelView.setViewName("redirect:/garson");
			else
				modelView.setViewName("redirect:/asci");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelView;
	}
	
	@RequestMapping("/siparis-sil")
	public ModelAndView siparisSil( @RequestParam("siparisid") int id,@AuthenticationPrincipal final UserPrincipal user){//UserPrincipal bizim olusturdugumuz.
		LOGGER.debug("KafkaController.siparisSil()");
		System.out.println("KafkaController.siparisSil() id : " + id);
		int kullaniciId;
		String currenUser = user.getUsername();
		String passw =  user.getPassword();
		DKUserInfo  userInfo = receiver.atomicDKUserInfoTable.get().getUserInfoTable().stream().filter(p->p.getKullaniciAdi().toString().equalsIgnoreCase(currenUser)).
				filter(k->k.getKullaniciSifre().toString().equalsIgnoreCase(passw)).collect(Collectors.toList()).get(0);
		if(currenUser.equalsIgnoreCase("admin")) {
			kullaniciId = 999;
		}else {
			kullaniciId = userInfo.getKullaniciID();
		}

		ModelAndView modelView = null;
		try {
			WebSiparisModel obj = new WebSiparisModel();
			obj.setSiparisId(Integer.toString(id));
			
			siparisCRUD(CRUD.DELETE,obj,kullaniciId);//Siparis Sil Kafkaya publish ediliyor.
			
			Thread.sleep(1000);//OSGI ugulamasından kafkada bulunan urunleri güncellemesini bekliyor.
			
			
			modelView = new ModelAndView();
			List<Siparis> siparisler = general.getSiparisler();
			modelView.addObject("siparisler", siparisler.stream().collect(Collectors.toList()));
			if(userInfo.getKullaniciTurAdi().toString().contains("Garson"))
				modelView.setViewName("redirect:/garson");
			else
				modelView.setViewName("redirect:/asci");
//			List<DKProductInfo> urunler = general.getModelProductsInfo();
//			modelView.addObject("urunler", urunler.stream().collect(Collectors.toList()));
//			
//			List<String> depolar =  general.getDepolar();
//			modelView.addObject("depolar", depolar.stream().collect(Collectors.toList()));
			
	//		modelView.setViewName("redirect:/depogorevlisi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelView;
	}
	

	@RequestMapping("/siparis-guncelle")
	@ResponseBody//return'u JSON'a çevirip gönderir.
	public  ResponseEntity  siparisguncelle(@RequestBody String updateSiparisModel,@AuthenticationPrincipal final UserPrincipal user)	//urunId,
	{
		LOGGER.debug("KafkaController.siparisguncelle()");
		int kullaniciId;
		String currenUser = user.getUsername();
		String passw =  user.getPassword();
		DKUserInfo  userInfo = receiver.atomicDKUserInfoTable.get().getUserInfoTable().stream().filter(p->p.getKullaniciAdi().toString().equalsIgnoreCase(currenUser)).
				filter(k->k.getKullaniciSifre().toString().equalsIgnoreCase(passw)).collect(Collectors.toList()).get(0);
		if(currenUser.equalsIgnoreCase("admin")) {
			kullaniciId = 999;
		}else {
			kullaniciId = userInfo.getKullaniciID();
		}

		WebSiparisModel obj = (WebSiparisModel) general.convertPostReceivedToObject(WebSiparisModel.class.getName(), updateSiparisModel);
		ModelAndView modelView = null;
		try {
			siparisCRUD(CRUD.UPDATE,obj,kullaniciId );//siparis Guncelle Kafkaya publish ediliyor.
			
			Thread.sleep(1000);//OSGI ugulamasından kafkada bulunan urunleri güncellemesini bekliyor.

//			modelView = new ModelAndView();
//			
//			urunler = general.getModelProductsInfo();
//			modelView.addObject("urunler", urunler.stream().collect(Collectors.toList()));
//			
//			List<String> depolar =  general.getDepolar();
//			modelView.addObject("depolar", depolar.stream().collect(Collectors.toList()));
//			
//			modelView.setViewName("redirect:/depogorevlisi		        
		} catch (Exception e) {
			e.printStackTrace();
	       // return new ResponseEntity< Object>(HttpStatus.CONFLICT)  ; //appropriate error code   
			MesajPojo mesaj = new MesajPojo();
			mesaj.setMesaj("Exception Olustu!!");
			HttpHeaders headers = new HttpHeaders();
		    headers.add("Responded", "KafkaController");
		    return ResponseEntity.ok().headers(headers).body(mesaj);
		}
		MesajPojo mesaj = new MesajPojo();
		mesaj.setMesaj("Basarili!!");
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Responded", "KafkaController");
	    return ResponseEntity.ok().headers(headers).body(mesaj);
		//  return urunler;   
		//return modelView;
	}

	private void siparisCRUD(CRUD islem, WebSiparisModel siparisModel, int kullaniciId) {
		System.out.println("KafkaController.siparisCRUD()");
		LOGGER.debug("KafkaController.siparisCRUD() islem : " + islem);
		Siparis siparis = null;
		SiparisCRUD siparisCRUD = new SiparisCRUD();
		try {
			if(islem == CRUD.DELETE) {
				siparis = general.getSiparis(Integer.valueOf(siparisModel.getSiparisId()));
				if(siparis == null)
					return;
				siparisCRUD.setAnayemekAdi(siparis.anayemekAdi);
				siparisCRUD.setAnayemekId(siparis.getAnayemekId());
				siparisCRUD.setCorbaAdi(siparis.corbaAdi.toString());
				siparisCRUD.setCorbaId(siparis.corbaId);
				siparisCRUD.setKullaniciAdi(siparis.kullaniciAdi.toString());
				siparisCRUD.setKullaniciId(siparis.kullaniciId);
				siparisCRUD.setKullaniciSoyadi(siparis.kullaniciSoyadi.toString());
				siparisCRUD.setKullaniciTurAdi(siparis.kullaniciTurAdi);
				siparisCRUD.setKullaniciTurId(siparis.kullaniciTurId);
				siparisCRUD.setMasaAdi(siparis.masaAdi.toString());
				siparisCRUD.setMasaId(siparis.masaId);
				siparisCRUD.setSalataAdi(siparis.salataAdi.toString());
				siparisCRUD.setSalataId(siparis.salataId);
				siparisCRUD.setSiparisDurumu(siparis.getSiparisDurumu());
				siparisCRUD.setSiparisId(siparis.getSiparisId());
				siparisCRUD.setTatliAdi(siparis.tatliAdi.toString());
				siparisCRUD.setTatliId(siparis.tatliId);
				
			}
			else if(islem == CRUD.CREATE){
				siparisCRUD.setSiparisId(0);
				siparisCRUD.setAnayemekAdi(siparisModel.yemekAdi);
				siparisCRUD.setCorbaAdi(siparisModel.corbaAdi);
				siparisCRUD.setMasaAdi(siparisModel.masaAdi);
				siparisCRUD.setSalataAdi(siparisModel.salataAdi);
				siparisCRUD.setSiparisDurumu(siparisModel.siparisDurumu);
				siparisCRUD.setTatliAdi(siparisModel.tatliAdi);
				siparisCRUD.setSiparisId(0);
				
				int anayemekId = receiver.atomicAnayemekKafkaModel.get().getAnayemekListesi().stream()
						.filter(p->p.getAnayemek().toString().equalsIgnoreCase(siparisModel.yemekAdi))
						.collect(Collectors.toList()).get(0).getAnayemekId();
				siparisCRUD.setAnayemekId(anayemekId);
				
				int corbaId = receiver.atomicCorbaKafkaModel.get().getCorbaListesi().stream()
						.filter(p->p.getCorbaAdi().toString().equalsIgnoreCase(siparisModel.corbaAdi))
						.collect(Collectors.toList()).get(0).getCorbaId();
				siparisCRUD.setCorbaId(corbaId);
				
				int masaId = receiver.atomicMasaKafkaModel.get().getMasaListesi().stream()
						.filter(p->p.getMasaAdi().toString().equalsIgnoreCase(siparisModel.masaAdi))
						.collect(Collectors.toList()).get(0).getMasaId();
				siparisCRUD.setMasaId(masaId);				
			
				int salataId = receiver.atomicSalataKafkaModel.get().getSalataListesi().stream()
						.filter(p->p.getSalataAdi().toString().equalsIgnoreCase(siparisModel.salataAdi))
						.collect(Collectors.toList()).get(0).getSalataId();
				siparisCRUD.setSalataId(salataId);
			
				int tatliId = receiver.atomicTatliKafkaModel.get().getTatliListesi().stream()
						.filter(p->p.getTatliAdi().toString().equalsIgnoreCase(siparisModel.tatliAdi))
						.collect(Collectors.toList()).get(0).getTatliId();
				siparisCRUD.setTatliId(tatliId);
				
				DKUserInfo kullaniciBilgileri = receiver.atomicDKUserInfoTable.get().getUserInfoTable().stream()
				.filter(p->p.getKullaniciID()==kullaniciId).collect(Collectors.toList()).get(0);
				
				siparisCRUD.setKullaniciAdi(kullaniciBilgileri.getKullaniciAdi());
				siparisCRUD.setKullaniciId(kullaniciId);
				siparisCRUD.setKullaniciSoyadi(kullaniciBilgileri.getKullaniciSoyadi());
				siparisCRUD.setKullaniciTurAdi(kullaniciBilgileri.getKullaniciTurAdi());
				siparisCRUD.setKullaniciTurId(kullaniciBilgileri.getKullaniciTurId());

			}else {//UPDATE
				
				siparisCRUD.setSiparisId(Integer.valueOf(siparisModel.getSiparisId()));
				siparisCRUD.setAnayemekAdi(siparisModel.yemekAdi);
				siparisCRUD.setCorbaAdi(siparisModel.corbaAdi);
				siparisCRUD.setMasaAdi(siparisModel.masaAdi);
				siparisCRUD.setSalataAdi(siparisModel.salataAdi);
				siparisCRUD.setSiparisDurumu(siparisModel.siparisDurumu);
				siparisCRUD.setTatliAdi(siparisModel.tatliAdi);

				int anayemekId = receiver.atomicAnayemekKafkaModel.get().getAnayemekListesi().stream()
									.filter(p->p.getAnayemek().toString().equalsIgnoreCase(siparisModel.yemekAdi))
									.collect(Collectors.toList()).get(0).getAnayemekId();
				siparisCRUD.setAnayemekId(anayemekId);
				
				int corbaId = receiver.atomicCorbaKafkaModel.get().getCorbaListesi().stream()
						.filter(p->p.getCorbaAdi().toString().equalsIgnoreCase(siparisModel.corbaAdi))
						.collect(Collectors.toList()).get(0).getCorbaId();
				siparisCRUD.setCorbaId(corbaId);
				
				int masaId = receiver.atomicMasaKafkaModel.get().getMasaListesi().stream()
						.filter(p->p.getMasaAdi().toString().equalsIgnoreCase(siparisModel.masaAdi))
						.collect(Collectors.toList()).get(0).getMasaId();
				siparisCRUD.setMasaId(masaId);				

				int salataId = receiver.atomicSalataKafkaModel.get().getSalataListesi().stream()
						.filter(p->p.getSalataAdi().toString().equalsIgnoreCase(siparisModel.salataAdi))
						.collect(Collectors.toList()).get(0).getSalataId();
				siparisCRUD.setSalataId(salataId);

				int tatliId = receiver.atomicTatliKafkaModel.get().getTatliListesi().stream()
						.filter(p->p.getTatliAdi().toString().equalsIgnoreCase(siparisModel.tatliAdi))
						.collect(Collectors.toList()).get(0).getTatliId();
				siparisCRUD.setTatliId(tatliId);
				
				
				DKUserInfo kullaniciBilgileri = receiver.atomicDKUserInfoTable.get().getUserInfoTable().stream()
				.filter(p->p.getKullaniciID()==kullaniciId).collect(Collectors.toList()).get(0);
				
				siparisCRUD.setKullaniciAdi(kullaniciBilgileri.getKullaniciAdi());
				siparisCRUD.setKullaniciId(kullaniciId);
				siparisCRUD.setKullaniciSoyadi(kullaniciBilgileri.getKullaniciSoyadi());
				siparisCRUD.setKullaniciTurAdi(kullaniciBilgileri.getKullaniciTurAdi());
				siparisCRUD.setKullaniciTurId(kullaniciBilgileri.getKullaniciTurId());
			}

			switch (islem) {
			case CREATE:
				siparisCRUD.setCrudType(CRUDType.CREATE);
				break;
			case DELETE:
				siparisCRUD.setCrudType(CRUDType.DELETE);
				break;
			case READ:
				siparisCRUD.setCrudType(CRUDType.READ);
				break;
			case UPDATE:
				siparisCRUD.setCrudType(CRUDType.UPDATE);
				break;
			default:
				break;
			}
			
			sender.sendUIGarsonSiparis(siparisCRUD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("KafkaController.siparisCRUD() ERROR : " + e.getMessage());
		}
	}
	
	enum CRUD{
		CREATE,
		READ,
		UPDATE,
		DELETE		
	}
	
}
