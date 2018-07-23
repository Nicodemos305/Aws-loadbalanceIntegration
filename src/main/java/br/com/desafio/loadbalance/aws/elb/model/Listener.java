package br.com.desafio.loadbalance.aws.elb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Listener {
	
	@JsonProperty("LoadBalancerArn")
	private String LoadBalancerArn;
	@JsonProperty("Protocol")
	private String Protocol;
	@JsonProperty("Port")
	private Integer Port;
	@JsonProperty("Certificates")
	private List<String> Certificates;
	@JsonProperty("SslPolicy")
	private String SslPolicy;
	@JsonProperty("DefaultActions")
	private String DefaultActions;
	@JsonProperty("Version")
	private String Version;
	
}
