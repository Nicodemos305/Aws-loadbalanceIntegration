package br.com.desafio.loadbalance.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class VirtualHost {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("environmentId")
	private Integer environmentId;
	@JsonProperty("projectId")
	private Integer projectId;
	@JsonProperty("rules")
	private List<Rule> rules;
	
}
