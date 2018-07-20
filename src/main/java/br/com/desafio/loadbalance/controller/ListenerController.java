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
	
	@PostMapping("createListener")
	public void createListener() {
		try {
			listenerService.createListener();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
		
	}
	
	@GetMapping("/deleteListener")
	public void deleteListener() {
		try {
			listenerService.deleteListener();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/describeListener")
	public void describeListener() {
		try {
			listenerService.describeListener();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/modifyListener")
	public void modifyListener() {
		try {
			listenerService.modifyListener();
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
}
