package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.service.TargetGroupService;

@RestController
@RequestMapping("/TargetGroup")
public class TargetGroupController  extends ControllerDefault{
	
	@Autowired
	private TargetGroupService targetGroupService;
	
	@PostMapping("/createTargetGroup")
	public void createTargetGroup() {
		try {
			targetGroupService.createTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/deleteTargetGroup")
	public void deleteTargetGroup() {
		try {
			targetGroupService.deleteTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/describeTargetGroup")
	public void describeTargetGroup() {
		try {
			targetGroupService.describeTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/modifyTargetGroup")
	public void modifyTargetGroup() {
		try {
			targetGroupService.modifyTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
}
