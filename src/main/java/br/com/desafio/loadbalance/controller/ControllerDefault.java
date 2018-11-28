package br.com.desafio.loadbalance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.util.Ressources;

/** 
 * 
 * Classe Controller default
 * @author felipe.nicodemos
*/
@Service
public class ControllerDefault  {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected Ressources ressources;
	
	
}
