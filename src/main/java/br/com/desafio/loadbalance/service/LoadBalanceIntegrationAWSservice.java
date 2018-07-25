package br.com.desafio.loadbalance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.model.Environment;
import br.com.desafio.loadbalance.model.Project;
import br.com.desafio.loadbalance.model.Rule;
import br.com.desafio.loadbalance.model.VirtualHost;
import br.com.desafio.loadbalance.util.PojoUtil;

@Service
public class LoadBalanceIntegrationAWSservice extends ServiceDefault{
	
	@Autowired
	private LoadBalanceService loadBalanceService;
	
	@Autowired
	private ListenerService listenerService;
	
	@Autowired
	private RulesService rulesService;

	@Autowired
	private TargetGroupService targetGroupService;
	
	public  String createLoadBalance(Config config) {

		try {
			Environment environmentDefault = null;
			Project projectDefault = null;
			List<Rule> rulesDefault = null;
			
			for(VirtualHost virtualHost : config.getVirtualhosts()) {
				Optional<Environment> environmentObj = config.getEnvironments().stream().filter(environment -> environment.getId().equals(virtualHost.getEnvironmentId())).findAny();
				environmentDefault = environmentObj.get();
				
				Optional<Project> projectObj = config.getProjects().stream().filter(project -> project.getId().equals(virtualHost.getProjectId())).findAny();
				projectDefault = projectObj.get();
				
				loadBalanceService.createLoadBalance(PojoUtil.fromToLoadBalancer(projectDefault));
				
			//	rulesDefault = virtualHost.getRules();
				
			//	for(Rule rule : rulesDefault) {
			//		rulesService.createRule(PojoUtil.fromToRule(rule,config.getRuleTypes(),config.getPools()),signature);
		//		}
				
				
			}
		//	listenerService.createListener(null);
		//	targetGroupService.createTargetGroup();
		}catch(Exception e) {
			logger.error("Erro na camada service",e);
		}
		
		return null;
	}
	
}
