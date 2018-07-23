package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.aws.elb.model.Rule;
import br.com.desafio.loadbalance.service.RulesService;

/** 
 * 
 * Classe Controller referente ao assunto Rules.
 * @author felipe.nicodemos 
*/
@RestController
@RequestMapping("/Rules")
public class RulesController  extends ControllerDefault{

	@Autowired
	private RulesService rulesService;
	
	/** 
	 * 
	 * Método responsável por criar um Rule
	 * @param Rule rule
	 *  
	*/
	@PostMapping("/createRule")
	public void createRule(Rule rule) {
		try {
			rulesService.setRestTemplate(builder);
			rulesService.createRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	
	}
	
	/** 
	 * 
	 * Método responsável por deletar um Rule
	 * @param Rule rule
	 *  
	*/
	@PostMapping("/deleteRule")
	public void deleteRule(Rule rule) {
		try {
			rulesService.deleteRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	/** 
	 * 
	 * Método responsável por listar  Rule
	 * @param Rule rule
	 *  
	*/
	@PostMapping("/describeRule")
	public void describeRule(Rule rule) {
		try {
			rulesService.describeRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		
	}
	
	/** 
	 * 
	 * Método responsável por atualizar um Rule
	 * @param Rule rule
	 *  
	*/
	@PostMapping("/modifyRule")
	public void modifyRule(Rule rule) {
		try {
			rulesService.modifyRule(rule);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
}
