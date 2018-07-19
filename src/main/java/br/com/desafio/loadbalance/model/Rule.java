package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Rule {
	
	@JsonProperty("typeId")
	private Integer typeId;
	@JsonProperty("poolId")
	private Integer poolId;
	@JsonProperty("rulePath")
	private String rulePath;
	
}
