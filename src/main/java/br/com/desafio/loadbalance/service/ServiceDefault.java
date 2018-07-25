package br.com.desafio.loadbalance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.desafio.loadbalance.util.Ressources;

public class ServiceDefault {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected Ressources ressources;
	
}
