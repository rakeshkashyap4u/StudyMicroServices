package com.example.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.currencyconversionservice.bean.CurrencyConversion;
import com.example.currencyconversionservice.bean.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeProxy  proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		HashMap<String, String> uriVariable = new HashMap<>();

		uriVariable.put("from", from);
		uriVariable.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class, uriVariable);
		
		CurrencyConversion currencyConversion =responseEntity.getBody();
		
		CurrencyConversion curecx = new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment());

		String port = env.getProperty("local.server.port");
		curecx.setEnvironment(port);

		return curecx;

	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion feigncalculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		
		
		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		CurrencyConversion curecx = new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment()+ " " + "Feign");

		//String port = env.getProperty("local.server.port");
		//curecx.setEnvironment(port);

		return curecx;

	}
}
