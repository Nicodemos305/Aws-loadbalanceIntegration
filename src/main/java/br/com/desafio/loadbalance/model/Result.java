package br.com.desafio.loadbalance.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4984710089082542786L;
	private String codigo;
	private List<String> mensagens;
	
}
