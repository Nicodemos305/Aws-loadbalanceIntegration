package br.com.desafio.loadbalance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;

import br.com.desafio.loadbalance.util.Ressources;

public class ServiceDefault {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected Ressources ressources;
	
	protected AWSCredentials credentials;
	protected AmazonElasticLoadBalancingClient client;
	
	
	public ServiceDefault() {
		 credentials = new BasicAWSCredentials(ressources.getKey(), ressources.getSecrectKey());
		 client = new AmazonElasticLoadBalancingClient(credentials);
		client.builder().setRegion(ressources.getRegionName());
		client.setEndpoint(ressources.getUrlAwsElb());
	}
	
}
