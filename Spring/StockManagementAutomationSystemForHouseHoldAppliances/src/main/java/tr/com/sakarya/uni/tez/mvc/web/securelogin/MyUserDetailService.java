package tr.com.sakarya.uni.tez.mvc.web.securelogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import tr.com.sakarya.uni.tez.kafka.models.DKUserInfo;
import tr.com.sakarya.uni.tez.kafka.models.DKUserInfoTable;
import tr.com.sakarya.uni.tez.mvc.web.consumer.Receiver;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private Receiver recevier;
	// Yetkili girişleri.
	//her login olunduğunda buraya gelir ve database'den veya elimzideki listeden 
	//user kontrolu yaparız.
	//user kontrolunden sonra eger AppSecurityConfig.configure() içinde 
	//successHandler(successHandler) tanımlanmısa sa CustomSuccessHandler'a gideriz.
	// tanımlanmamışsa girişi "/" ile yaptığımızdan "/"'a redirect olunur. Oda homeController'a düşer.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("MyUserDetailService.loadUserByUsername() -- username : " + username );
		User user = null;
		if(username.equalsIgnoreCase("admin")) {
			user = new User();
			user.setUsername(username);
			user.setRole("ROL_Admin");
			user.setPassword("admin");
		}
		if( Receiver.atomicUserInfoTable.get() != null) {
			List<DKUserInfo> userInfos = Receiver.atomicUserInfoTable.get().getUserInfoTable();
			for (DKUserInfo dkUserInfo : userInfos) {
				if(username.equalsIgnoreCase(dkUserInfo.getKullaniciAdi().toString())) {
					user = new User();
					user.setUsername(username);
					user.setPassword(dkUserInfo.getKullaniciSifre().toString());
					user.setRole(dkUserInfo.getKullaniciTurAdi().toString());
				}
			}
		}
		
		if(user == null)
			throw new UsernameNotFoundException("User 404 :( ");
		
		return new UserPrincipal(user);
	}

}
