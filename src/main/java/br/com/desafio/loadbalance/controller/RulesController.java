package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.aws.elb.model.Rule;
import br.com.desafio.loadbalance.service.RulesService;

@RestController
@RequestMapping("/Rules")
public class RulesController  extends ControllerDefault{

	@Autowired
	private RulesService rulesService;
	
	@PostMapping("/createRule")
	public void createRule(Rule rule) {
		try {
			rulesService.createRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	
	}
	
	@PostMapping("/deleteRule")
	public void deleteRule(Rule rule) {
		try {
			rulesService.deleteRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/describeRule")
	public void describeRule(Rule rule) {
		try {
			rulesService.describeRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		
	}
	
	@PostMapping("/modifyRule")
	public void modifyRule(Rule rule) {
		try {
			rulesService.modifyRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
}
