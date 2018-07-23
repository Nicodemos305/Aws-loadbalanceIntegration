package br.com.desafio.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.loadbalance.service.LoadBalanceService;

@RestController
@RequestMapping("/")
public class LoadBalanceController extends ControllerDefault{

	@Autowired
	private LoadBalanceService loadBalanceService;


}