package br.com.desafio.loadbalance.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pool extends Base{

	@JsonProperty("properties")
	private Properties properties;
	@JsonProperty("targets")
	private List<Target> targets;
	
}