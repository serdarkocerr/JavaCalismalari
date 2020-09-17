package tr.com.siparis.sistemi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tr.com.siparis.sistemi.kafka.model.Siparis;



@Controller
public class HomeController {


	@Autowired 
	private General general;
	private  int siparisCnt=0;
    
	@RequestMapping("/")
	public String home(Model m, Authentication authentication) {
		String currentRole = "";
		String view = "home";
		System.out.println("HomeController.home()");
		
		ArrayList<String> roles = getRoles(authentication);
		if(roles.size()==0)
			return view;
		
		currentRole = getRoles(authentication).get(0);
		if(currentRole.equalsIgnoreCase("ROL_Garson"))
			view="redirect:/garson";
		else if (currentRole.equalsIgnoreCase("ROL_Asci")) 
			view="redirect:/asci";

		return view;
	}
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("HomeController.login()");
		return "login1";
	}
	
	@RequestMapping("/asci")
	public String asci(Model model) {
		
		List<Siparis> siparisler = general.getSiparisler();
		model.addAttribute("siparisler", siparisler.stream().collect(Collectors.toList()));

		List<String> masalar =  general.getMasalar();
		model.addAttribute("masalar", masalar.stream().collect(Collectors.toList()));

		
		System.out.println("HomeController.asci()");
		return "asci";
 
	}
	
	@RequestMapping("/garson")
	public String garson(Model model) {
		int siparisAlmaCnt= 5;
		List<Siparis> siparisler = general.getSiparisler();
		while(siparisAlmaCnt != 0) {
			
			if(this.siparisCnt != siparisler.size() ) {//Siparis topici biraz gec geliyor. O sebepten guncellenme durumunu bekliyoruz.
				this.siparisCnt = siparisler.size();
				break;
			}
			
			siparisler = general.getSiparisler();
			try {
				Thread.sleep(1000);
				siparisAlmaCnt--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("siparisler", siparisler.stream().collect(Collectors.toList()));

		List<String> masalar =  general.getMasalar();
		model.addAttribute("masalar", masalar.stream().collect(Collectors.toList()));

		List<String> corbalar =  general.getCorbalar();
		model.addAttribute("corbalar", corbalar.stream().collect(Collectors.toList()));

		List<String> anayemekler =  general.getAnaYemekler();
		model.addAttribute("anayemekler", anayemekler.stream().collect(Collectors.toList()));

		List<String> salatalar =  general.getSalatalar();
		model.addAttribute("salatalar", salatalar.stream().collect(Collectors.toList()));
		
		List<String> tatlilar =  general.getTatlilar();
		model.addAttribute("tatlilar", tatlilar.stream().collect(Collectors.toList()));

		
		System.out.println("HomeController.garson()");
		return "garson";
	}

	private ArrayList<String> getRoles(Authentication authentication) {
		Collection<?extends GrantedAuthority> granted = authentication.getAuthorities();
		ArrayList<String> roles = new ArrayList<String>();
		    for(int i=0;i<granted.size();i++){
		    	roles.add(granted.toArray()[i] + "");
				System.out.println("HomeController.getRoles() : role "+roles.size()+": "+ roles.get(roles.size()-1) );

		    }   
		    return roles;
	}
	
	
}
