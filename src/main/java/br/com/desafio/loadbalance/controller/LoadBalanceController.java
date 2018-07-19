package br.com.desafio.loadbalance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.service.LoadBalanceService;

@RestController
@RequestMapping("/")
public class LoadBalanceController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoadBalanceService loadBalanceService;
	
	@Autowired
	RestTemplateBuilder builder;

	@PostMapping("/insertPolicyELB")
	public  @ResponseBody Config insertPolicyELB(@RequestBody(required=true) Config config) {
		try {
			loadBalanceService.insertPolicyELB(config,builder);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		return config;
	}

}