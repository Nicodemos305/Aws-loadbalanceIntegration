package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerPolicyRequest;

import br.com.desafio.loadbalance.model.Result;
import br.com.desafio.loadbalance.model.Rule;

@Service
public class RuleService extends ServiceDefault{
	
	public  Result createLoadBalance(Rule rule,Result result,String loadBalancer) {
		try {
			CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest = new CreateLoadBalancerPolicyRequest();
			createLoadBalancerPolicyRequest.setLoadBalancerName(loadBalancer);
			createLoadBalancerPolicyRequest.setPolicyName(null);
			createLoadBalancerPolicyRequest.setPolicyTypeName(null);
			client.createLoadBalancerPolicy(createLoadBalancerPolicyRequest);
		}catch(Exception e) {
			result.getMensagens().add(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e.getMessage());
			logger.error(ressources.getMsgClasse()+this.getClass().getName()+ressources.getMsgService()+e.getMessage(),e);
		}
		return result;
	}
}
