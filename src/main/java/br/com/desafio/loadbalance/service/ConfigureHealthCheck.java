package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.elasticloadbalancing.model.ConfigureHealthCheckRequest;
import com.amazonaws.services.elasticloadbalancing.model.HealthCheck;

@Service
public class ConfigureHealthCheck extends ServiceDefault{
	
	public void configureHealthCheck(String loadBalanceName,String target) {
		try {
			AWSCredentials credentials = new BasicAWSCredentials(ressources.getKey(), ressources.getSecrectKey());
			AmazonElasticLoadBalancingClient client = new AmazonElasticLoadBalancingClient(credentials);
			client.builder().setRegion(ressources.getRegionName());
			client.setEndpoint(ressources.getUrlAwsElb());
			ConfigureHealthCheckRequest configureHealthCheckRequest = new ConfigureHealthCheckRequest();
			HealthCheck healthCheck = new HealthCheck();
			healthCheck.setTarget("HTTP:5000"+target);
			healthCheck.setInterval(10);
			healthCheck.setHealthyThreshold(5);
			healthCheck.setTimeout(2);
			healthCheck.setUnhealthyThreshold(2);
			configureHealthCheckRequest.setHealthCheck(healthCheck);
			configureHealthCheckRequest.setLoadBalancerName(loadBalanceName);
			client.configureHealthCheck(configureHealthCheckRequest);
		}catch(Exception e) {
			logger.error("Erro na camada service",e);
		}
	}
}
