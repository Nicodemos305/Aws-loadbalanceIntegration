package br.com.desafio.loadbalance.aws.elb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoadBalancer {

	@JsonProperty("name")
	private String name;
	@JsonProperty("subNets")
	private List<String> subNets;


}
