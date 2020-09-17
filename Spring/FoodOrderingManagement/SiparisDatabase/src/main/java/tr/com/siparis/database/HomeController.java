package tr.com.siparis.database;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.com.siparis.database.kafka.producer.DatabaseKafkaSender;
import tr.com.siparis.database.manager.dao.AnayemekDaoImp;
import tr.com.siparis.database.manager.dao.KullaniciDaoImp;
import tr.com.siparis.database.manager.dao.SiparisDaoImp;
import tr.com.siparis.database.model.KullaniciAllContent;
import tr.com.siparis.database.model.SiparisAllContent;
import tr.com.siparis.database.model.anayemek;

@Controller
public class HomeController {
	
//	@Autowired
//	AnayemekRepo anayemekRepo;
//	@Autowired
//	TestRepo testRepo;
	@Autowired
	DatabaseKafkaSender dbKafkaSender;
	SiparisDaoImp siparisDao;
	KullaniciDaoImp kullanicidDao;
	
	 public HomeController() {
		 System.out.println("HomeController.HomeController()");
	 }
	
	  @PostConstruct
	  public void init() {
	    System.out.println("HomeController.init()");
	  }
	  
	  
	@RequestMapping("/")
	//@ResponseBody--> ResponseBody bir view döndürtmez. retun eden ifade client tarafa gönderilir. Burada String index gönderilirdi.
	public String  home()
	{
		dbKafkaSender.init();
		System.out.println("home page requested.");
		return "index";
	}
	
	
	@GetMapping("getAllContent" )
	public String getAnayemek(Model m) {
		
//		m.addAttribute("result", anayemekRepo.getOne(anayemekid));
		if(siparisDao == null) {
			siparisDao = new SiparisDaoImp();
		}
		 Collection<SiparisAllContent> allContSiparis = siparisDao.getAllContent();
		
		 if(kullanicidDao == null) {
			 kullanicidDao = new KullaniciDaoImp();
		 }
		 Collection<KullaniciAllContent>  allContKullanici= kullanicidDao.getAllContent();
		 
			m.addAttribute("siparisler", allContSiparis);
			m.addAttribute("kullanicilar", allContKullanici);

		
		return "allcontent";
	}
	
}
