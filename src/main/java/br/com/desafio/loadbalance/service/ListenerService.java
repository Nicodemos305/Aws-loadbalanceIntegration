package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

@Service
public class ListenerService extends ServiceDefault{
	
	public void createListener() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void deleteListener() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void describeListener() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void modifyListener() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
}