package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.service.LoadBalanceIntegrationAWSservice;

@RestController
@RequestMapping("/LoadBalanceIntegrationAWS")
public class LoadBalanceIntegrationAWS extends ControllerDefault{

	@Autowired
	private LoadBalanceIntegrationAWSservice loadBalanceIntegrationAWSservice;
	
	@PostMapping("/createLoadBalance")
	public  @ResponseBody Config createLoadBalance(@RequestBody(required=true) Config config) {
		try {
			loadBalanceIntegrationAWSservice.setRestTemplate(builder);
			loadBalanceIntegrationAWSservice.createLoadBalance(config);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		return config;
	}
	
	@PostMapping("/createLoadBalancePath")
	public  @ResponseBody Config createLoadBalancePath(@RequestBody(required=true) Config config) {
		try {
			loadBalanceIntegrationAWSservice.setRestTemplate(builder);
			loadBalanceIntegrationAWSservice.createLoadBalancePath(config);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		return config;
	}
}
