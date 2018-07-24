package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.aws.elb.model.Rule;

@Service
public class RulesService extends ServiceDefault{

	public void createRule(Rule rule,String signature) {
		try {
			String retorno = null;
		//	retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getCreateRule()).concat("&version=2018-07-23&AUTHPARAMS=").concat(signature),String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service",e);
		}
	}
	
	public void deleteRule(Rule rule,String signature) {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getDeleteRule()),String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void describeRule(Rule rule) {
		try {
			String retorno = null;
			retorno = restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getDescribeRules()),String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void modifyRule(Rule rule) {
		try {
			String retorno = null;
			retorno = restTemplate.getForObject(ressources.getUrlAwsElb().concat(""),String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
}
