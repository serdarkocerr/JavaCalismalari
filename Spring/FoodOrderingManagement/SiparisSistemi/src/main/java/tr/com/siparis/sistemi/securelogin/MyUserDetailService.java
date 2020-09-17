package tr.com.siparis.sistemi.securelogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import tr.com.siparis.sistemi.consumer.KafkaReceiver;
import tr.com.siparis.sistemi.kafka.model.DKUserInfo;


@Service
public class MyUserDetailService implements UserDetailsService {

//	@Autowired
//	private Receiver recevier;
	
	//her login olunduğunda buraya gelir ve database'den veya elimzideki listeden 
	//user kontrolu yaparız. Buradan HomeController'A düşer. Cünkü success handler
	//kısmı aktif değil.Aktif olsaydı CustomSuccessHandler'a düşerdi.
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
		if( KafkaReceiver.atomicDKUserInfoTable.get() != null) {
			List<DKUserInfo> userInfos = KafkaReceiver.atomicDKUserInfoTable.get().getUserInfoTable();
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
