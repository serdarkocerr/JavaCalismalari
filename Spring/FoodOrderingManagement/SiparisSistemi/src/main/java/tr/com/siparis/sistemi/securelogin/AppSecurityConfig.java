package tr.com.siparis.sistemi.securelogin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	AuthenticationSuccessHandler successHandler;
	
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());//--> şifreleme yok.

		return provider;
	}

	
	
/*	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("**").password("**").roles("ROL_Garson");
//		auth.inMemoryAuthentication()
//			.withUser("Nil").password("nkocer").roles("ROL_Asci")
//			.and()
//			.withUser("Serdar").password("skocer").roles("ROL_Garson");
		
	//	auth.userDetailsService(userDetailsService);
//		if(receiver.atomicUserInfoTable == null || receiver.atomicUserInfoTable.get() == null) {
//			return;
//		}
		auth.authenticationProvider(authProvider());
//		receiver.atomicUserInfoTable.get().getUserInfoTable().stream().forEach(a->{
//			String userName = a.getKullaniciAdi().toString();
//			String sifre = a.getKullaniciSifre().toString();
//			String rol = a.getKullaniciTurAdi().toString();
//			try {
//				auth.inMemoryAuthentication()
//				.withUser(userName).password(sifre).roles(rol);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		});
		
	}
*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/**
		 * 
		 * 		.successHandler(successHandler)
		 * eklendiğinde CustomSuccessHandler'a gider. Orada 
		 * onAuthenticationSuccess olduğunda yapılacak işlemlere karar verilir.
		 * Daha sonradan 
		 * public void configure(AuthenticationManagerBuilder auth)
		 * içinde belirtilen kullanıcı-şifre-roller'e erişim yetkisi verilir.
		 *  .antMatchers("/userPage").access("hasRole('ROL_Garson')")
		 *  şeklinde bi ön koşul koyulduğunda kullanıcı-şifre-roller tanıtılmalıdır.
		 * */
		
		http
			.csrf().disable()
			.authorizeRequests()
			//.antMatchers("/", "/home", "/js/**", "/css/**","/resources/**","/templates/**").permitAll()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			//.logoutSuccessUrl("/logout-success").permitAll();
			.logoutSuccessUrl("/login").permitAll();
		
//		http
//		.csrf().disable()
//		.authorizeRequests()
////		 .antMatchers("/userPage").access("hasRole('ROL_Garson')")
////		 .antMatchers("/adminPage").access("hasRole('ROL_Asci')")
//		 .antMatchers("/Garson").access("hasRole('ROL_Garson')")
//		 .antMatchers("/Asci").access("hasRole('ROL_Asci')")
////			.antMatchers("/Garson").hasAnyRole("ROL_Garson")
////			.antMatchers("/Asci").hasAnyRole("ROL_Asci")
//		.and().formLogin().loginPage("/login")
//			//.successHandler(successHandler)
//		.permitAll()
//		.and().logout();
		
		/*http
		.csrf().disable()
		.authorizeRequests()
		 .antMatchers("/userPage").access("hasRole('ROL_Asci')")
		 .antMatchers("/adminPage").access("hasRole('ROL_Asci')")
		.antMatchers("/Garson").hasAnyRole("ROL_Garson")
		.antMatchers("/Asci").hasAnyRole("ROL_Asci")
		.and().formLogin().loginPage("/login")
			.successHandler(successHandler)
		.permitAll()
		.and().logout();
		*/
//	    http.csrf().disable()
//        .authorizeRequests()
//            .antMatchers("/resources/**").permitAll() 
//            .anyRequest().authenticated()
//            .and()
//        .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//        .logout()                                    
//            .permitAll();
//		.antMatchers("/homePage").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//		.antMatchers("/userPage").access("hasRole('ROLE_USER')")
//		.antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
	//	super.configure(http);
	}
	

}
