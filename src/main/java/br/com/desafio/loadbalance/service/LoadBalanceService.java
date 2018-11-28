package br.com.desafio.loadbalance.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.DuplicateLoadBalancerNameException;
import com.amazonaws.services.elasticloadbalancing.model.Listener;

import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;
import br.com.desafio.loadbalance.model.Result;

@Service
public class LoadBalanceService extends ServiceDefault{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public  Result createLoadBalance(LoadBalancer loadBalancer,Result result) {
		try {
		    CreateLoadBalancerRequest lbRequest = new CreateLoadBalancerRequest();
		    Listener listener = new Listener();
		    listener.setInstancePort(8081);
		    listener.setInstanceProtocol("http");
		    listener.setLoadBalancerPort(8080);
		    listener.setProtocol("http");
		    List<Listener> lista = new ArrayList<Listener>();
		    lista.add(listener);
		    lbRequest.setListeners(lista);
		    lbRequest.setLoadBalancerName(loadBalancer.getName());
		    lbRequest.setSubnets(loadBalancer.getSubNets());
		    client.createLoadBalancer(lbRequest);
			result.getMensagens().add("ELB  "+loadBalancer.getName()+" Cadastrado com sucesso!");
		}catch(DuplicateLoadBalancerNameException e1) {
			result.getMensagens().add(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e1.getMessage());
			logger.error(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e1.getMessage(),e1);
		}catch(Exception e) {
			result.getMensagens().add(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e.getMessage());
			logger.error(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e.getMessage(),e);
		}
		
		return result;
	}
	
	
}