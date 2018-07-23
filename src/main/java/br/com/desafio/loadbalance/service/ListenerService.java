package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.aws.elb.model.Listener;

@Service
public class ListenerService extends ServiceDefault{
	
	public void createListener(Listener listener) {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getCreateListener()), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void deleteListener(Listener listener) {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getDeleteListener()), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void describeListener(Listener listener) {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getDescribeListeners()), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
	
	public void modifyListener(Listener listener) {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getModifyListener()), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
}