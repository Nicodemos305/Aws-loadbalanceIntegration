package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Target extends Base{
	
	@JsonProperty("targetId")
	private Integer targetId;
	@JsonProperty("properties")
	private Properties properties;
	
	public Integer getTargetId() {
		return targetId;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
	
}
