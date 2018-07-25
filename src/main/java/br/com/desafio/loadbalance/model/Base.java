package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Base {
	
	@JsonProperty("id")
	protected Integer id;
	@JsonProperty("name")
	protected String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
