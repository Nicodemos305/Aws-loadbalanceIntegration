package br.com.desafio.loadbalance.util;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.loadbalance.aws.elb.model.Listener;
import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;
import br.com.desafio.loadbalance.aws.elb.model.Rule;
import br.com.desafio.loadbalance.aws.elb.model.TargetGroup;
import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.model.Pool;
import br.com.desafio.loadbalance.model.Project;
import br.com.desafio.loadbalance.model.RuleType;
import br.com.desafio.loadbalance.model.Target;

/** 
 * 
 * Classe utilitária para converter Pojos da aplicação 
 * para dos serviços AWS
 * @author felipe.nicodemos
*/
public class PojoUtil {

	
	
	public static LoadBalancer fromToLoadBalancer(Project project,Config config) {
		LoadBalancer loadBalancer = new LoadBalancer();
		loadBalancer.setName(project.getName());
		
		List<String> subNets = new ArrayList<String>();
		
		for(Target target : config.getTargets()) {
			if(target != null && target.getName() != null) {
				subNets.add(target.getName());
			}
		}
		loadBalancer.setSubNets(subNets);
	
		return loadBalancer;
		
	}
	
	public static Listener fromToLoadListener(Config config) {
		Listener listener = new Listener();

		return null;
		
	}
	
	public static Rule fromToRule(br.com.desafio.loadbalance.model.Rule rule,List<RuleType> ruleType,List<Pool> pools) {
			Rule ruleAws = new Rule();
	
		
		return ruleAws;
		
	}
	
	public static TargetGroup fromToTargetGroup(Config config) {
		TargetGroup targetGroup = new TargetGroup();
		targetGroup.setName(config.getTargets().get(0).getName());		
		return null;
		
	}
}
