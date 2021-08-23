package com.serdar.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	//Spring data JPA will convert this method into SQL query. (From and To are both attribute of CurrencyExcange class.)
	CurrencyExchange findByFromAndTo(String from, String to);
	
}
