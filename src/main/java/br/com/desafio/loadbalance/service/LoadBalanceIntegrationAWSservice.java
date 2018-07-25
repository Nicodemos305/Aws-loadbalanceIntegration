package br.com.desafio.loadbalance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;
import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.model.Environment;
import br.com.desafio.loadbalance.model.Pool;
import br.com.desafio.loadbalance.model.Project;
import br.com.desafio.loadbalance.model.Result;
import br.com.desafio.loadbalance.model.VirtualHost;
import br.com.desafio.loadbalance.util.PojoUtil;

@Service
public class LoadBalanceIntegrationAWSservice extends ServiceDefault{
	
	@Autowired
	private LoadBalanceService loadBalanceService;
	
	@Autowired
	private ConfigureHealthCheck configureHealthCheck;
	
	public  Result  createLoadBalance(Config config) {
		Result result = new Result();
		try {

			Project projectDefault = null;

			for(VirtualHost virtualHost : config.getVirtualhosts()) {
				Optional<Environment> environmentObj = config.getEnvironments().stream().filter(environment -> environment.getId().equals(virtualHost.getEnvironmentId())).findAny();
				
				Optional<Project> projectObj = config.getProjects().stream().filter(project -> project.getId().equals(virtualHost.getProjectId())).findAny();
				projectDefault = projectObj.get();
				
				LoadBalancer loadBalancer = PojoUtil.fromToLoadBalancer(projectDefault,config);
				loadBalanceService.createLoadBalance(loadBalancer);
				
				for(Pool pool : config.getPools()) {
					configureHealthCheck.configureHealthCheck(loadBalancer.getName(), pool.getProperties().getHealthCheckPath());
				}
		
				result.setMensagem("loadBalance cadastrado com sucesso");
			}

		}catch(Exception e) {
			result.setMensagem("Erro ao cadastrar HealthCheck");
			logger.error("Erro na camada service",e);
		}
		return result;
	}
	
}
