package tr.com.sakarya.uni.tez.mvc.web.securelogin;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.ui.Model;

import tr.com.sakarya.uni.tez.mvc.web.consumer.Receiver;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	AuthenticationSuccessHandler successHandler;
	
	@Autowired
	Receiver receiver;
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());//--> şifreleme yok.

		return provider;
	}

	
/***
 * SpringBoot role yönetimi.
 * Asagidaki configure(AuthenticationManagerBuilder auth) method ile bu saglaniyor. Bu method kullanıcıları ve rolleri initalize etmemize yarıyor.
 * Kullanıcılara roles() methoduyla role atanıyor. Bu aynı zamanda authorities()  methoduylada atanabilir. 
 * Peki farkı nedir?
 * roles() methoduyla atandığında Spring otomatik olarak başına ROLES_ ekler. Örneğin aşağıdaki durumda ROLES_ROL_Yonetici
 * authorities() methodu ise bunu bizden bekler. ROLE_ eklemez. 
 * 
 * configure(HttpSecurity http) methodu ile ise access() methoduya rollerin giriş yapabilecek sayfaları eklenir.
 * .antMatchers("/userPage").access("hasRole('ROLE_USER')")
 * 
 * Bu projede Spring'in role yönetimini kullanmadık. Kendimiz yönlendirmeleri MyUserDetail servisi içinde loadUserByUsername() methodunda
 * User yaratıp role içini dolduruyoruz.(kullanıcı ismi, şifre ve role ismi ile)
 *  Ardından bunu UserPrincipal ile UserDetaillere ekleyip Spring Boot'a return ediyoruz.Springboot bunu kendi Authorities içine set ediyor bişekilde.
 *  
 * Böylelikle eğer bir requet geldiyse, HomeController içinde requestin Authentication  değişkeniyle  requesti atan kullanıcının set edilmiş rollerini alabilyoruz.
 * kullanıcının rolüne göre redirect sayfasını belirliyoruz. 
 * Bizim yönetimimizde bu sebepten configure(AuthenticationManagerBuilder auth) methodu yok. 
 * Ayrıca configure(HttpSecurity http) methodu içinde role göre redirect işlemide yok. Bunu Controller içinde yaptık.
 * 	public String home(Model m, Authentication authentication) 

 * **/	
/*	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("**").password("**").roles("ROL_DepoGorevlisi");
//		auth.inMemoryAuthentication()
//			.withUser("Nil").password("nkocer").roles("ROL_Yonetici")
//			.and()
//			.withUser("Serdar").password("skocer").roles("ROL_DepoGorevlisi");
		
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
		 *  .antMatchers("/userPage").access("hasRole('ROL_DepoGorevlisi')")
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
////		 .antMatchers("/userPage").access("hasRole('ROL_DepoGorevlisi')")
////		 .antMatchers("/adminPage").access("hasRole('ROL_Yonetici')")
//		 .antMatchers("/depogorevlisi").access("hasRole('ROL_DepoGorevlisi')")
//		 .antMatchers("/yonetici").access("hasRole('ROL_Yonetici')")
////			.antMatchers("/depogorevlisi").hasAnyRole("ROL_DepoGorevlisi")
////			.antMatchers("/yonetici").hasAnyRole("ROL_Yonetici")
//		.and().formLogin().loginPage("/login")
//			//.successHandler(successHandler)
//		.permitAll()
//		.and().logout();
		
		/*http
		.csrf().disable()
		.authorizeRequests()
		 .antMatchers("/userPage").access("hasRole('ROL_Yonetici')")
		 .antMatchers("/adminPage").access("hasRole('ROL_Yonetici')")
		.antMatchers("/depogorevlisi").hasAnyRole("ROL_DepoGorevlisi")
		.antMatchers("/yonetici").hasAnyRole("ROL_Yonetici")
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
		super.configure(http);
	}
	

}
