package br.com.desafio.loadbalance.service;

import br.com.desafio.loadbalance.model.Config;

public class LoadBalanceIntegrationAWSservice extends ServiceDefault{

	public  String createLoadBalance(Config config) {
		String retorno = null;

		try {
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return retorno;
	}
	
	public  String createLoadBalancePath(Config config) {
		String retorno = null;

		try {
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return retorno;
	}
	
}
