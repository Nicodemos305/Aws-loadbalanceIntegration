package br.com.desafio.loadbalance.model;

import lombok.Data;

@Data
public class Target {
	private Integer id;
	private String name;
	private Properties properties;
	
}
