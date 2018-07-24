package br.com.desafio.loadbalance.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import br.com.desafio.loadbalance.util.Ressources;

public class ServiceDefault {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected Ressources ressources;

	RestTemplate restTemplate;
	
	public void setRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	
	private Map<String,String> autenticacaoAWS(){
		Map<String,String> map = new HashMap<>();
		map.put("X-Amz-Security-Token", "e3ad599e81dcc66d1d3bf149e1a8dd5e73de896764f5311761b56856163f284e");
		
		return map;
	}
	
}
