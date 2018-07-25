package br.com.desafio.loadbalance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.util.AmazonSignature;
import br.com.desafio.loadbalance.util.Ressources;

/** 
 * 
 * Classe Controller default
 * @author felipe.nicodemos
*/
@Service
public class ControllerDefault  {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplateBuilder builder;
	
	@Autowired
	protected Ressources ressources;
	
	private String signature;
	

	
	
	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
