package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.aws.elb.model.Listener;
import br.com.desafio.loadbalance.service.ListenerService;

@RestController
@RequestMapping("/Listener")
public class ListenerController extends ControllerDefault{
	
	@Autowired
	private ListenerService listenerService;
	
	@PostMapping("createListener")
	public void createListener(Listener listener) {
		try {
			listenerService.createListener(listener);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@GetMapping("/deleteListener")
	public void deleteListener(Listener listener) {
		try {
			listenerService.deleteListener(listener);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/describeListener")
	public void describeListener(Listener listener) {
		try {
			listenerService.describeListener(listener);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
	@PostMapping("/modifyListener")
	public void modifyListener(Listener listener) {
		try {
			listenerService.modifyListener(listener);
		}catch(Exception e) {
			logger.error("Erro na camada de controle"+e.getMessage(),e);
		}
	}
	
}
