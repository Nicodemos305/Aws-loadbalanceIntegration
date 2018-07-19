package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@JsonIgnoreProperties()
@Data
public class Pool {


	private Integer id;
	

	private String name;
	

	
}
