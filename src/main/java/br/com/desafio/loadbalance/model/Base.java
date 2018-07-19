package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Base {
	
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	
}
