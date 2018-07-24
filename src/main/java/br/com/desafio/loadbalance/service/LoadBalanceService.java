package br.com.desafio.loadbalance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;

@Service
public class LoadBalanceService extends ServiceDefault{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public  String createLoadBalance(LoadBalancer loadBalancer,String signature) {
		String  retorno = null;
		try {
			 retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getCreateLoadBalancer()) ,String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service",e);
		}
		
		return retorno;
	}
	
}