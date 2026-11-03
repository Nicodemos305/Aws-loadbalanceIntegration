package br.com.desafio.loadbalance.service;

import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.model.Result;

/** Application use case. This prototype validates desired state; provisioning is not implemented. */
@Service
public class LoadBalanceIntegrationAWSservice {
	private final ConfigValidator validator;

	public LoadBalanceIntegrationAWSservice(ConfigValidator validator) {
		this.validator = validator;
	}

	public Result createLoadBalance(Config config, Result result) {
		String validationError = validator.validate(config);
		if (validationError != null) {
			result.setCodigo("400");
			result.getMensagens().add(validationError);
			return result;
		}
		result.setCodigo("VALIDATION_ONLY");
		result.getMensagens().add("Configuração válida. Nenhum recurso AWS foi criado: o provisionamento de ALB ainda não está implementado.");
		return result;
	}
}
