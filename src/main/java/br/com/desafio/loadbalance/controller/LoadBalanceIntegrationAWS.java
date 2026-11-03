package br.com.desafio.loadbalance.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.model.Result;
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

	@GetMapping("/health")
	public String health() {
		return "UP";
	}
	
	/** 
	 * 
	 * Método responsável por criar um LoadBalance
	 * @param  Config config
	*/
	@PostMapping("/createLoadBalance")
	public  @ResponseBody Result createLoadBalance(@RequestBody(required=true) Config config) {
		Result result = newResult();
		try {
			result =  loadBalanceIntegrationAWSservice.createLoadBalance(config,result);
		}catch(Exception e) {
			result.setCodigo("400");
			result.getMensagens().add("Não foi possível processar a configuração.");
			logger.error("Falha ao processar configuração",e);
		}
		
		return  result;
	}
	
	/** 
	 * 
	 * Método responsável por criar um LoadBalance atráves de um Path
	 * @param  Srting path
	*/
	@GetMapping("/createLoadBalancePath")
	public  @ResponseBody Result createLoadBalancePath(@RequestParam("path") String path) {
		Result result = newResult();
		try {
			result =loadBalanceIntegrationAWSservice.createLoadBalance(Config.deserealize(path),result);
		}catch(Exception e) {
			result.setCodigo("400");
			result.getMensagens().add("Não foi possível ler a configuração informada.");
			logger.error("Falha ao ler configuração",e);
		}
		return result;
	}

	private Result newResult() {
		Result result = new Result();
		result.setMensagens(new ArrayList<String>());
		return result;
	}
}
