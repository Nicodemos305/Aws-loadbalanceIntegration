package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.service.RulesService;

@RestController
@RequestMapping("/Rules")
public class RulesController  extends ControllerDefault{

	@Autowired
	private RulesService rulesService;
	
	@PostMapping("/createRule")
	public void createRule() {
		try {
			rulesService.createRule();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	
	}
	
	@PostMapping("/deleteRule")
	public void deleteRule() {
		try {
			rulesService.deleteRule();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/describeRule")
	public void describeRule() {
		try {
			rulesService.describeRule();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		
	}
	
	@PostMapping("/modifyRule")
	public void modifyRule() {
		try {
			rulesService.modifyRule();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
}
