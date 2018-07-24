package br.com.desafio.loadbalance.aws.elb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoadBalancer {

	@JsonProperty("name")
	private String name;
	@JsonProperty("subnet")
	private String subnet;
	@JsonProperty("subnet2")
	private String subnet2;
	@JsonProperty("version")
	private String version;

}
