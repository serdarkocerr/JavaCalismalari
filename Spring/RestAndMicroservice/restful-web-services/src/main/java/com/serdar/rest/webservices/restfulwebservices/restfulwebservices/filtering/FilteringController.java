package com.serdar.rest.webservices.restfulwebservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	
	

	//Dynamic filtering for field1. field2
	@GetMapping("/filtering")
	public MappingJacksonValue retriveExampleBean() {
		
		ExampleBean exampleBean = new ExampleBean("value1","value2","value3");
		
		MappingJacksonValue mapping = new MappingJacksonValue(exampleBean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
				
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilterExample", filter);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	
	
	//Dynamic filtering for field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retriveExample2Bean() {
		
		ExampleBean exampleBean = new ExampleBean("value1","value2","value3");
		
		MappingJacksonValue mapping = new MappingJacksonValue(exampleBean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
				
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilterExample", filter);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
}
