package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

@Service
public class TargetGroupService extends ServiceDefault{
	
	public void createTargetGroup() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void deleteTargetGroup() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void describeTargetGroup() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void modifyTargetGroup() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
}
