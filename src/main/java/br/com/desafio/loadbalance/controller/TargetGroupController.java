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
		targetGroupService.createTargetGroup();
	}
	
	@PostMapping("/deleteTargetGroup")
	public void deleteTargetGroup() {
		targetGroupService.deleteTargetGroup();
	}
	
	@PostMapping("/describeTargetGroup")
	public void describeTargetGroup() {
		targetGroupService.describeTargetGroup();
	}
	
	@PostMapping("/modifyTargetGroup")
	public void modifyTargetGroup() {
		targetGroupService.modifyTargetGroup();
	}
	
}
