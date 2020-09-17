package tr.com.sakarya.uni.tez.mvc.web;

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

import tr.com.sakarya.uni.tez.kafka.models.DKProductInfo;
import tr.com.sakarya.uni.tez.mvc.web.consumer.Receiver;
import tr.com.sakarya.uni.tez.mvc.web.producer.Sender;

@Controller
public class HomeController {


	@Autowired 
	private General general;
    
	@RequestMapping("/")
	public String home(Model m, Authentication authentication) {
		String currentRole = "";
		String view = "home";
		System.out.println("HomeController.home()");
		
		ArrayList<String> roles = getRoles(authentication);
		if(roles.size()==0)
			return view;
		
		currentRole = getRoles(authentication).get(0);
		if(currentRole.equalsIgnoreCase("ROL_DepoGorevlisi"))
			view="redirect:/depogorevlisi";
		else if (currentRole.equalsIgnoreCase("ROL_Yonetici")) 
			view="redirect:/yonetici";

		return view;
	}
	
	@RequestMapping("/login")
	public String login() {
		System.out.println("HomeController.login()");
		return "login1";
	}
	
	@RequestMapping("/yonetici")
	public String yonetici(Model model) {
		
		List<DKProductInfo> urunler = general.getModelProductsInfo();
		model.addAttribute("urunler", urunler.stream().collect(Collectors.toList()));

		List<String> depolar =  general.getDepolar();
		model.addAttribute("depolar", depolar.stream().collect(Collectors.toList()));

		
		System.out.println("HomeController.yonetici()");
		return "yonetici";

	}
	
	@RequestMapping("/depogorevlisi")
	public String depogorevlisi(Model model) {
	
		List<DKProductInfo> urunler = general.getModelProductsInfo();
		model.addAttribute("urunler", urunler.stream().collect(Collectors.toList()));
		
		List<String> depolar =  general.getDepolar();
		model.addAttribute("depolar", depolar.stream().collect(Collectors.toList()));

		System.out.println("HomeController.depogorevlisi()");
		return "depogorevlisi";
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
