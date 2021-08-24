package com.serdar.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange",url = "localhost:8000" )//name is name of service that is  serving  as rest.
//remove url = "localhost:8000" if eurka perform load balance 
@FeignClient(name = "currency-exchange")//name is name of service that is  serving  as rest.
public interface CurrencyExchangeProxy  {

	// CurrencyConversion matching/wrapping the structure of response
	//same structure of currency-excange-service retrieveExchange method.
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchange(@PathVariable String from, @PathVariable String to);
}
