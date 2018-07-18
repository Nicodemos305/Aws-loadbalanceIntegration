package br.com.desafio.loadbalance.model;

import java.util.List;

import lombok.Data;

@Data
public class Pool {

	private Integer id;
	private String name;
	private List<Properties> properties;
	
}
