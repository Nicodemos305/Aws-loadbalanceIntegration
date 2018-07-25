package br.com.desafio.loadbalance.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.Listener;

import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;

@Service
public class LoadBalanceService extends ServiceDefault{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public  String createLoadBalance(LoadBalancer loadBalancer) {
		String  retorno = null;
		try {
	
			AWSCredentials credentials = new BasicAWSCredentials(ressources.getKey(), ressources.getSecrectKey());
			
			AmazonElasticLoadBalancingClient client = new AmazonElasticLoadBalancingClient(credentials);
			
			client.builder().setRegion("us-east-2");
			client.setEndpoint("elasticloadbalancing.us-east-2.amazonaws.com");
			CreateLoadBalancerRequest createLoadBalance = new CreateLoadBalancerRequest();
				
		    CreateLoadBalancerRequest lbRequest = new CreateLoadBalancerRequest();
		    Listener listener = new Listener();
		    listener.setInstancePort(8081);
		    listener.setInstanceProtocol("http");
		    listener.setLoadBalancerPort(25);
		    listener.setProtocol("http");
		    List<Listener> lista = new ArrayList<Listener>();
		    lista.add(listener);
		    lbRequest.setListeners(lista);
		    lbRequest.setLoadBalancerName(loadBalancer.getName());
		    List<String> subnet = new ArrayList<String>();
		    subnet.add("subnet-911259f9");
		    lbRequest.setSubnets(subnet);
		    client.createLoadBalancer(lbRequest);
			
		}catch(Exception e) {
			logger.error("Erro na camada service",e);
		}
		
		return retorno;
	}
	
	


	
}