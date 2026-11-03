package br.com.desafio.loadbalance.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.model.Pool;
import br.com.desafio.loadbalance.model.Rule;
import br.com.desafio.loadbalance.model.Target;
import br.com.desafio.loadbalance.model.VirtualHost;

/** Validates references in the declarative load-balancer configuration. */
@Component
public class ConfigValidator {

	public String validate(Config config) {
		if (config == null) return "A configuração é obrigatória.";
		if (empty(config.getEnvironments())) return "Informe ao menos um environment.";
		if (empty(config.getProjects())) return "Informe ao menos um project.";
		if (empty(config.getRuleTypes())) return "Informe ao menos um ruleType.";
		if (empty(config.getTargets())) return "Informe ao menos um target.";
		if (empty(config.getPools())) return "Informe ao menos um pool.";
		if (empty(config.getVirtualhosts())) return "Informe ao menos um virtualhost.";

		Set<Integer> environmentIds = new HashSet<Integer>();
		config.getEnvironments().forEach(item -> { if (item != null && item.getId() != null) environmentIds.add(item.getId()); });
		Set<Integer> projectIds = new HashSet<Integer>();
		config.getProjects().forEach(item -> { if (item != null && item.getId() != null) projectIds.add(item.getId()); });
		Set<Integer> ruleTypeIds = new HashSet<Integer>();
		config.getRuleTypes().forEach(item -> { if (item != null && item.getId() != null) ruleTypeIds.add(item.getId()); });
		Set<Integer> targetIds = new HashSet<Integer>();
		for (Target target : config.getTargets()) {
			if (target == null || target.getId() == null || target.getName() == null || target.getName().trim().isEmpty()) return "Todo target precisa de id e name.";
			targetIds.add(target.getId());
		}
		Set<Integer> poolIds = new HashSet<Integer>();
		for (Pool pool : config.getPools()) {
			if (pool == null || pool.getId() == null || pool.getProperties() == null) return "Todo pool precisa de id e properties.";
			poolIds.add(pool.getId());
			java.util.List<Target> members = pool.getProperties().getTargets() != null ? pool.getProperties().getTargets() : pool.getTargets();
			if (empty(members)) return "Todo pool precisa referenciar ao menos um target.";
			for (Target target : members) {
				if (target == null || target.getTargetId() == null || !targetIds.contains(target.getTargetId())) return "Pool referencia target inexistente.";
			}
		}
		for (VirtualHost host : config.getVirtualhosts()) {
			if (host == null || host.getName() == null || host.getName().trim().isEmpty()) return "Todo virtualhost precisa de name.";
			if (!environmentIds.contains(host.getEnvironmentId())) return "Virtualhost referencia environment inexistente.";
			if (!projectIds.contains(host.getProjectId())) return "Virtualhost referencia project inexistente.";
			if (empty(host.getRules())) return "Todo virtualhost precisa de ao menos uma rule.";
			for (Rule rule : host.getRules()) {
				if (rule == null || !poolIds.contains(rule.getPoolId())) return "Rule referencia pool inexistente.";
				if (!ruleTypeIds.contains(rule.getTypeId())) return "Rule referencia ruleType inexistente.";
				if (rule.getRulePath() == null || rule.getRulePath().trim().isEmpty()) return "Toda rule precisa de rulePath.";
			}
		}
		return null;
	}

	private boolean empty(java.util.Collection<?> values) { return values == null || values.isEmpty(); }
}
