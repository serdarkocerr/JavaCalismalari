package tr.com.sakarya.uni.tez.mvc.web;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


import tr.com.sakarya.uni.tez.kafka.models.CRUDType;
import tr.com.sakarya.uni.tez.kafka.models.DKProductInfo;
import tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD;
import tr.com.sakarya.uni.tez.mvc.web.avroserializer.AvroDeserializer;
import tr.com.sakarya.uni.tez.mvc.web.model.MesajPojo;
import tr.com.sakarya.uni.tez.mvc.web.model.TestPojo;
import tr.com.sakarya.uni.tez.mvc.web.model.WebUrunModel;
import tr.com.sakarya.uni.tez.mvc.web.producer.Sender;

@Controller
public class KafkaController {

	  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

	  
	@Autowired
	private Sender sender;
	@Autowired
	private General general;
	
	@PostMapping(value = "urun-ekle")
	public ModelAndView urunekle( @ModelAttribute("a1")WebUrunModel urun){
		LOGGER.debug("KafkaController.urunekle()");
		System.out.println("KafkaController.urunekle() urunAdi : " + urun.urunAdi);

		ModelAndView modelView = null;
		
		try {
			urunCRUD(CRUD.CREATE,urun);//Urun Ekle Kafkaya publish ediliyor.
			Thread.sleep(1000);//OSGI ugulamasından kafkada bulunan urunleri güncellemesini bekliyor.
			modelView = new ModelAndView();
			
			List<DKProductInfo> urunler = general.getModelProductsInfo();
			modelView.addObject("urunler", urunler.stream().collect(Collectors.toList()));
			
			List<String> depolar =  general.getDepolar();
			modelView.addObject("depolar", depolar.stream().collect(Collectors.toList()));
			modelView.setViewName("redirect:/depogorevlisi");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelView;
	}
	
	@RequestMapping("/urun-sil")
	public ModelAndView urunsil( @RequestParam("urunid") int id) {
		LOGGER.debug("KafkaController.urunsil()");
		System.out.println("KafkaController.urunsil() id : " + id);
		
		ModelAndView modelView = null;
		try {
			WebUrunModel obj = new WebUrunModel();
			obj.setUrunId(Integer.toString(id));
			
			urunCRUD(CRUD.DELETE,obj);//Urun Sil Kafkaya publish ediliyor.
			
			Thread.sleep(1000);//OSGI ugulamasından kafkada bulunan urunleri güncellemesini bekliyor.
			
			
			modelView = new ModelAndView();
			
			List<DKProductInfo> urunler = general.getModelProductsInfo();
			modelView.addObject("urunler", urunler.stream().collect(Collectors.toList()));
			
			List<String> depolar =  general.getDepolar();
			modelView.addObject("depolar", depolar.stream().collect(Collectors.toList()));
			
			modelView.setViewName("redirect:/depogorevlisi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelView;
	}
	

	@RequestMapping("/urun-guncelle")
	@ResponseBody//return'u JSON'a çevirip gönderir.
	public  ResponseEntity  urunguncelle(@RequestBody String updateUrunModel)	//urunId,
	{
		LOGGER.debug("KafkaController.urunguncelle()");
		//TestPojo obj = (TestPojo) general.convertPostReceivedToObject(TestPojo.class.getName(),testpojo);
		//System.out.println("KafkaController.urunguncelle() id : " + id);
		WebUrunModel obj = (WebUrunModel) general.convertPostReceivedToObject(WebUrunModel.class.getName(), updateUrunModel);
		ModelAndView modelView = null;
		List<DKProductInfo> urunler = null;
		try {
			urunCRUD(CRUD.UPDATE,obj );//Urun Guncelle Kafkaya publish ediliyor.
			
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

	private void urunCRUD(CRUD islem, WebUrunModel urunModel) {
		System.out.println("KafkaController.urunCRUD()");
		LOGGER.debug("KafkaController.urunCRUD() islem : " + islem);
		DKProductInfo urun = null;
		UKProductCRUD topicCRUDIslem = new UKProductCRUD();
		try {
			if(islem == CRUD.DELETE) {
				urun = general.getUrun(Integer.valueOf(urunModel.getUrunId()));
				if(urun == null)
					return;
				topicCRUDIslem.setDepoId(urun.getDepoId());
				topicCRUDIslem.setMarkaId(urun.getMarkaId());
				topicCRUDIslem.setUrunId(urun.getUrunId());
				topicCRUDIslem.setUrunTurId(urun.getUrunTurId());
				
				topicCRUDIslem.setDepoAdi(urun.getDepoAdi());
				topicCRUDIslem.setMarkaAdi(urun.getMarkaAdi());
				topicCRUDIslem.setUrunAdi(urun.getUrunAdi());
				topicCRUDIslem.setUrunTurAdi(urun.getUrunTurAdi());
			}
			else {//CREATE or UPDATE
				topicCRUDIslem.setUrunId(Integer.valueOf(urunModel.getUrunId()));
				topicCRUDIslem.setDepoAdi(urunModel.getDepoAdi());
				topicCRUDIslem.setMarkaAdi(urunModel.getMarkaAdi());
				topicCRUDIslem.setUrunAdi(urunModel.getUrunAdi());
				topicCRUDIslem.setUrunTurAdi(urunModel.getUrunTurAdi());
				
				topicCRUDIslem.setDepoId(0);
				topicCRUDIslem.setMarkaId(0);
				topicCRUDIslem.setUrunTurId(0);
			}

			
			switch (islem) {
			case CREATE:
				topicCRUDIslem.setCrudType(CRUDType.CREATE);
				break;
			case DELETE:
				topicCRUDIslem.setCrudType(CRUDType.DELETE);
				break;
			case READ:
				topicCRUDIslem.setCrudType(CRUDType.READ);
				break;
			case UPDATE:
				topicCRUDIslem.setCrudType(CRUDType.UPDATE);
				break;
			default:
				break;
			}
			
			sender.send(topicCRUDIslem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("KafkaController.urunCRUD() ERROR : " + e.getMessage());
		}
	}
	
	enum CRUD{
		CREATE,
		READ,
		UPDATE,
		DELETE		
	}
	
}
