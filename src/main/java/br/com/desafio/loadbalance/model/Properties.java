package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Properties extends Base{
	
	
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("healthy")
	private String healthy;
	@JsonProperty("healthCheckPath")
	private String healthCheckPath;
	@JsonProperty("loadBalancePolicy")
	private String loadBalancePolicy;
	
	public String getHealthy() {
		return healthy;
	}
	public String getHealthCheckPath() {
		return healthCheckPath;
	}
	public String getLoadBalancePolicy() {
		return loadBalancePolicy;
	}
	public void setHealthy(String healthy) {
		this.healthy = healthy;
	}
	public void setHealthCheckPath(String healthCheckPath) {
		this.healthCheckPath = healthCheckPath;
	}
	public void setLoadBalancePolicy(String loadBalancePolicy) {
		this.loadBalancePolicy = loadBalancePolicy;
	}
	
	
	
	
	
	

}
