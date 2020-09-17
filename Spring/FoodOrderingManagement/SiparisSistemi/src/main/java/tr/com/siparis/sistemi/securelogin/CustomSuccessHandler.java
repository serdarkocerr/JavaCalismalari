package tr.com.siparis.sistemi.securelogin;


import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	// Kimlik doğrulama sağlandığında buraya gelir ve 
	// rolüne göre istenilen durum yapılır.
	//buradan sonra ise AppSecurityConfig içinde belirlemiş olduğumuz
	//AppSecurityConfig -- configure(AuthenticationManagerBuilder auth)
	//methodundaki kullanıcı-şifre-role ile uyumlu olanlara redirect izni verilir.
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = null;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("role " + grantedAuthority.getAuthority());
			if (grantedAuthority.getAuthority().equals("ROLE_ROL_Garson")
					|| grantedAuthority.getAuthority().equals("ROL_Garson")) {
				redirectUrl = "/garson";
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ROL_Asci")
					|| grantedAuthority.getAuthority().equals("ROLE_ROL_Asci")) {
				redirectUrl = "/asci";
				break;
			}
//			else {
//				redirectUrl = "/login";
//			}
		}
		System.out.println("redirectUrl " + redirectUrl);
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}