package br.com.desafio.loadbalance.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafio.loadbalance.util.JsonUtil;
import lombok.Data;

@Data
public class Config {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@JsonProperty("environments")
	private List<Environment> environments;
	@JsonProperty("projects")
	private List<Project> projects;
	@JsonProperty("ruleTypes")
	private List<RuleType> ruleTypes;
	@JsonProperty("targets")
	private List<Target> targets;
	@JsonProperty("pools")
	private List<Pool> pools;
	@JsonProperty("virtualhosts")
	private List<VirtualHost> virtualhosts;
	
	public Config deserealize(String path) {
		byte[] jsonData;
		try {
			jsonData = Files.readAllBytes(Paths.get("src/main/resources/config.json"));
			ObjectMapper objectMapper = JsonUtil.initJsonMapper();
			Config config = objectMapper.readValue(jsonData, Config.class);
			return config;
		} catch (IOException e) {
			logger.error("Erro ao deserializar objeto Config "+e.getMessage(),e);
			return null;
		}
	}
 	
}
