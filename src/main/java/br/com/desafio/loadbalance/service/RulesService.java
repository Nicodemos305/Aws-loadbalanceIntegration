package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

@Service
public class RulesService extends ServiceDefault{

	public void createRule() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void deleteRule() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void describeRule() {
		try {
			String retorno = null;
			retorno = restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void modifyRule() {
		try {
			String retorno = null;
			retorno = restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
}
