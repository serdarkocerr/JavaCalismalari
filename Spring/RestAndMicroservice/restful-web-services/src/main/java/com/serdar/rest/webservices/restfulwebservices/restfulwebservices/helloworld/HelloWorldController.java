package com.serdar.rest.webservices.restfulwebservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//Read .properties file
	@Autowired
	private	MessageSource messageSource;

	@GetMapping(path = "/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	//hello-world-bean
	//Bean return example
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	///hello-world/path-variable/serdar
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s",name ));
		
	}
	
	
	//Internationalization
	//	<!-- Internationalization | i18n | customize based on user language-->
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(
			//@RequestHeader(name="Accept-Language", required = false) Locale locale
			){
		
		
		
		//return messageSource.getMessage("good.morning.message", null, "Default Message",locale);
		return messageSource.getMessage("good.morning.message", null, "Default Message",LocaleContextHolder.getLocale());
	}
	
	
}
