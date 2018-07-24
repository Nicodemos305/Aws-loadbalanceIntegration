package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

@Service
public class TargetGroupService extends ServiceDefault{
	
	public void createTargetGroup() {
		try {
			String retorno = null;
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb().concat(ressources.getCreateTargetGroup()), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
	}
}
