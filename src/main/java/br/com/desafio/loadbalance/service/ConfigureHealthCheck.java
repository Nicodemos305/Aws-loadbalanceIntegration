package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.elasticloadbalancing.model.ConfigureHealthCheckRequest;
import com.amazonaws.services.elasticloadbalancing.model.HealthCheck;

import br.com.desafio.loadbalance.model.Result;

@Service
public class ConfigureHealthCheck extends ServiceDefault{
	
	public Result configureHealthCheck(String loadBalanceName,String target,Result result) {
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
			result.getMensagens().add(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e.getMessage());
			logger.error(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e.getMessage(),e);
		}
		return result;
	}
}
