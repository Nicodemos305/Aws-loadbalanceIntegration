package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Target extends Base{
	
	@JsonProperty("targetId")
	private Integer targetId;
	@JsonProperty("properties")
	private Properties properties;
	
	
}
