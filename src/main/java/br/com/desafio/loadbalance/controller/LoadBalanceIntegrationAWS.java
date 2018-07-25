package br.com.desafio.loadbalance.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/** 
	 * 
	 * Método responsável por criar um LoadBalance
	 * @param  Config config
	*/
	@PostMapping("/createLoadBalance")
	public  @ResponseBody Result createLoadBalance(@RequestBody(required=true) Config config) {
		Result result = new Result();
		List<String> listaMensagens = new ArrayList<String>();
		result.setMensagens(listaMensagens);
		try {
			result =  loadBalanceIntegrationAWSservice.createLoadBalance(config,result);
		}catch(Exception e) {
			result.getMensagens().add("Classe "+this.getClass().getName()+" Erro na camada Controller "+e.getMessage());
			logger.error("Classe "+this.getClass().getName()+" Erro na camada Controller "+e.getMessage(),e);
		}
		
		return  result;
	}
	
	/** 
	 * 
	 * Método responsável por criar um LoadBalance atráves de um Path
	 * @param  Srting path
	*/
	@PostMapping("/createLoadBalancePath")
	public  @ResponseBody Result createLoadBalancePath(@RequestBody(required=true) String path) {
		Result result = new Result();
		List<String> listaMensagens = new ArrayList<String>();
		result.setMensagens(listaMensagens);
		try {
			result =loadBalanceIntegrationAWSservice.createLoadBalance(Config.deserealize(path),result);
		}catch(Exception e) {
			result.getMensagens().add("Classe "+this.getClass().getName()+" Erro na camada Controller "+e.getMessage());
			logger.error("Classe "+this.getClass().getName()+" Erro na camada Controller "+e.getMessage(),e);
		}
		return result;
	}
}
