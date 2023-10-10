package com.example.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.bean.CurrencyExchange;
import com.example.currencyexchangeservice.repo.CurrencyExchangeRepositry;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	private CurrencyExchangeRepositry repo;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to)
	{
	
		
		
		CurrencyExchange curecx=	repo.findByFromAndTo(from, to) ;
				//new CurrencyExchange(100L,from ,to, BigDecimal.valueOf(50));
		if(curecx==null)
		throw new  RuntimeException("Unable to Find data for" +from+" from "+to);
			
		String port= env.getProperty("local.server.port");
		curecx.setEnvironment(port);
		 
		 return curecx;
	
		
}

}
