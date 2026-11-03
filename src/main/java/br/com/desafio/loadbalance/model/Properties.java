package br.com.desafio.loadbalance.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


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
	@JsonProperty("targets")
	private List<Target> targets;
	public List<Target> getTargets() { return targets; }
	public void setTargets(List<Target> targets) { this.targets = targets; }
	
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
