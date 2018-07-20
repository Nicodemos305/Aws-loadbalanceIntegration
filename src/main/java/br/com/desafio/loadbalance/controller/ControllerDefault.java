package br.com.desafio.loadbalance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class ControllerDefault  {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplateBuilder builder;
	
}
