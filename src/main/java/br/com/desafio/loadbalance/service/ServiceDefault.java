package br.com.desafio.loadbalance.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	
	public 	HttpHeaders  gerarHeaderRequest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Amz-Algorithm","");
		headers.set("X-Amz-Credential","");
		headers.set("X-Amz-Date","");
		headers.set("X-Amz-Expires","");
		headers.set("X-Amz-SignedHeaders","");
		headers.set("X-Amz-Signature","");
		return headers;
	}
	
}
