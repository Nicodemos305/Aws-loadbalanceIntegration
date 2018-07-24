package br.com.desafio.loadbalance.aws.elb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TargetGroup {

	@JsonProperty("name")
	private String name;
	@JsonProperty("protocol")
	private String protocol;
	@JsonProperty("port")
	private Integer port;
	@JsonProperty("vPcId")
	private String vPcId;
	@JsonProperty("version")
	private String version;
		
}
