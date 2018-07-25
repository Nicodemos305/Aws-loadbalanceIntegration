package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.service.LoadBalanceIntegrationAWSservice;


/** 
 * 
 * Classe Controller referente ao assunto integração LoadBalance AWS.
 * @author felipe.nicodemos 
*/
@RestController
@RequestMapping("/LoadBalanceIntegrationAWS")
public class LoadBalanceIntegrationAWS extends ControllerDefault{

	@Autowired
	private LoadBalanceIntegrationAWSservice loadBalanceIntegrationAWSservice;
	
	/** 
	 * 
	 * Método responsável por criar um LoadBalance
	 * @param  Config config
	*/
	@PostMapping("/createLoadBalance")
	public  @ResponseBody Config createLoadBalance(@RequestBody(required=true) Config config) {
		try {
			
			loadBalanceIntegrationAWSservice.setRestTemplate(builder);
			loadBalanceIntegrationAWSservice.createLoadBalance(config,getSignature());
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		return config;
	}
	
	/** 
	 * 
	 * Método responsável por criar um LoadBalance atráves de um Path
	 * @param  Srting path
	*/
	@PostMapping("/createLoadBalancePath")
	public  @ResponseBody Config createLoadBalancePath(@RequestBody(required=true) String path) {
		try {
			loadBalanceIntegrationAWSservice.setRestTemplate(builder);
			loadBalanceIntegrationAWSservice.createLoadBalance(Config.deserealize(path),getSignature());
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		return null;
	}
}
