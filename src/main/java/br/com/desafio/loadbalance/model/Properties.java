package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Properties {
	
	@JsonProperty("healthy")
	private String healthy;
	@JsonProperty("healthCheckPath")
	private String healthCheckPath;
	@JsonProperty("loadBalancePolicy")
	private String loadBalancePolicy;
	

}
