package br.com.desafio.loadbalance.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;
import br.com.desafio.loadbalance.model.Config;

@Service
public class LoadBalanceService extends ServiceDefault{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public  String createLoadBalance(LoadBalancer loadBalancer) {
		String retorno = null;

		try {
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return retorno;
	}
	

	public String deletePolicyELB(Config config,RestTemplateBuilder builder) {
		String retorno = null;

		try {
			restTemplate = builder.build();
			retorno = 	restTemplate.getForObject("", String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return retorno;
	}
	
	public  List<Config> listPolicyELB(Config config,RestTemplateBuilder builder) {
		List<Config> retorno = null;

		try {
			restTemplate = builder.build();
			retorno = 	restTemplate.getForObject("", List.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return retorno;
	}
	
}