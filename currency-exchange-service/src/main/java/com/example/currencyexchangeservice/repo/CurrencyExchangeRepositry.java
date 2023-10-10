package com.example.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.currencyexchangeservice.bean.CurrencyExchange;


public interface CurrencyExchangeRepositry extends JpaRepository<CurrencyExchange, Long>{
	
	CurrencyExchange findByFromAndTo(String from ,String to);

}
