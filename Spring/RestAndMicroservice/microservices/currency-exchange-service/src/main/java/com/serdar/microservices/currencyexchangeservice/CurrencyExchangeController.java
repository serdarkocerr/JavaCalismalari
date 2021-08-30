package com.serdar.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {
	
	Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository repository;

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchange(@PathVariable String from, @PathVariable String to) {

		logger.info("retriveExchange() called with {} to {} ",from,to);
		
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
