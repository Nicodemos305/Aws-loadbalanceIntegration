package br.com.desafio.loadbalance.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.desafio.loadbalance.model.Config;
import br.com.desafio.loadbalance.util.JsonUtil;

public class ConfigValidatorTest {
	private final ConfigValidator validator = new ConfigValidator();

	@Test
	public void acceptsRepositoryExampleConfiguration() throws Exception {
		Config config = JsonUtil.initJsonMapper().readValue(
				getClass().getResourceAsStream("/config.json"), Config.class);
		assertNull(validator.validate(config));
	}

	@Test
	public void rejectsMissingConfiguration() {
		assertEquals("A configuração é obrigatória.", validator.validate(null));
	}

	@Test
	public void rejectsConfigurationWithoutEnvironments() {
		Config config = new Config();
		assertEquals("Informe ao menos um environment.", validator.validate(config));
	}
}
