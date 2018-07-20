package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.service.ListenerService;

@RestController
@RequestMapping("/Listener")
public class ListenerController extends ControllerDefault{
	
	@Autowired
	private ListenerService listenerService;
	
	@PostMapping("/createListener")
	public void createListener() {
		listenerService.createListener();
		
	}
	
	@GetMapping("/deleteListener")
	public void deleteListener() {
		listenerService.deleteListener();
		
	}
	
	@PostMapping("/describeListener")
	public void describeListener() {
		listenerService.describeListener();
	}
	
	@PostMapping("/modifyListener")
	public void modifyListener() {
		listenerService.modifyListener();
	}
	
}
