package br.com.desafio.loadbalance.aws.elb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Rule {
	
	@JsonProperty("ListenerArn")
	private String ListenerArn;
	@JsonProperty("Priority")
	private Integer Priority;
	@JsonProperty("Conditions")
	private List<String> Conditions;
	@JsonProperty("Actions")
	private List<String> Actions;
	@JsonProperty("Version")
	private String Version;

	
}
