package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Properties {
	
	@JsonProperty("healthy")
	private String healthy;
	
}
