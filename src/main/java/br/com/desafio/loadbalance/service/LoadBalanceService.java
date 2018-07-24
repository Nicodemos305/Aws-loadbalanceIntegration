package br.com.desafio.loadbalance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;
import br.com.desafio.loadbalance.model.Config;

@Service
public class LoadBalanceService extends ServiceDefault{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public  String createLoadBalance(LoadBalancer loadBalancer,String signature) {
		String  retorno = null;
		try {
			Map<String,String> mapa = gerarHeaderRequest();
			 retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getCreateLoadBalancer()), String.class);
			// restTemplate.getForObject(url, responseType, uriVariables)
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return retorno;
	}
	
}