package br.com.desafio.loadbalance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.model.Config;

@Service
public class LoadBalanceIntegrationAWSservice extends ServiceDefault{
	
	@Autowired
	private LoadBalanceService loadBalanceService;
	
	@Autowired
	private ListenerService listenerService;
	
	@Autowired
	private RulesService rulesService;

	@Autowired
	private TargetGroupService targetGroupService;
	
	public  String createLoadBalance(Config config) {

		try {
			loadBalanceService.insertPolicyELB(null);
			listenerService.createListener(null);
			rulesService.createRule(null);
			targetGroupService.createTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return null;
	}
	
	public  String createLoadBalancePath(String path) {
		String retorno = null;

		try {
			retorno = 	restTemplate.getForObject(ressources.getUrlAwsElb(), String.class);
		}catch(Exception e) {
			logger.error("Erro na camada service");
		}
		
		return retorno;
	}
	
}
