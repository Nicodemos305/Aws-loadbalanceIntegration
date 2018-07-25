package br.com.desafio.loadbalance.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pool extends Base{

	@JsonProperty("properties")
	private Properties properties;
	@JsonProperty("targets")
	private List<Target> targets;
	public Properties getProperties() {
		return properties;
	}
	public List<Target> getTargets() {
		return targets;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}
	
	
	
}