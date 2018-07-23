package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.service.TargetGroupService;


/** 
 * 
 * Classe Controller referente ao assunto TargetGroupController.
 * @author felipe.nicodemos 
*/
@RestController
@RequestMapping("/TargetGroup")
public class TargetGroupController  extends ControllerDefault{
	
	@Autowired
	private TargetGroupService targetGroupService;
	
	/** 
	 * 
	 * Método responsável por criar um TargetGroup
	 * @param TargetGroup  targetGroup
	 *  
	*/
	@PostMapping("/createTargetGroup")
	public void createTargetGroup() {
		try {
			targetGroupService.createTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	/** 
	 * 
	 * Método responsável por deletar um TargetGroup
	 * @param TargetGroup  targetGroup
	 *  
	*/
	@PostMapping("/deleteTargetGroup")
	public void deleteTargetGroup() {
		try {
			targetGroupService.deleteTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	/** 
	 * 
	 * Método responsável por listar  TargetGroup
	 * @param TargetGroup  targetGroup
	 *  
	*/
	@PostMapping("/describeTargetGroup")
	public void describeTargetGroup() {
		try {
			targetGroupService.describeTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	/** 
	 * 
	 * Método responsável por atualizar um TargetGroup
	 * @param TargetGroup  targetGroup
	 *  
	*/
	@PostMapping("/modifyTargetGroup")
	public void modifyTargetGroup() {
		try {
			targetGroupService.modifyTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
}
