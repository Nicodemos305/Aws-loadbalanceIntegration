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
		rulesService.createRule();
	
	}
	
	@PostMapping("/deleteRule")
	public void deleteRule() {
		rulesService.deleteRule();
	}
	
	@PostMapping("/describeRule")
	public void describeRule() {
		rulesService.describeRule();
		
	}
	
	@PostMapping("/modifyRule")
	public void modifyRule() {
		rulesService.modifyRule();
	}
	
}
