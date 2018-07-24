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
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public 	Map<String,String>  gerarHeaderRequest() {
		Map<String,String> mapa = new HashMap<String,String>();
		mapa.put("X-Amz-Algorithm","");
		mapa.put("X-Amz-Credential","");
		mapa.put("X-Amz-Date","");
		mapa.put("X-Amz-Expires","");
		mapa.put("X-Amz-SignedHeaders","");
		mapa.put("X-Amz-Signature","");
		return mapa;
	}
	
}
