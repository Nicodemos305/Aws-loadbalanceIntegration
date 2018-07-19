package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RuleType {
	
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	
}
