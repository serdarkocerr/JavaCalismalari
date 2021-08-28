package com.serdar.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository repository;

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchange(@PathVariable String from, @PathVariable String to) {

		//CurrencyExchange currencyExchange = new CurrencyExchange(10001L, from, to, BigDecimal.valueOf(50));
		CurrencyExchange currencyExchangeFromH2Database = repository.findByFromAndTo(from, to);
		if (currencyExchangeFromH2Database == null) {
			throw new  RuntimeException("Unable to Find data for " + from + "to" + to);
		}
			
		
		String port = environment.getProperty("local.server.port");
		currencyExchangeFromH2Database.setEnvironment(port);
		
		
		return currencyExchangeFromH2Database;
		

	}

}
