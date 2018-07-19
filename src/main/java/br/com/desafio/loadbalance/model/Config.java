package br.com.desafio.loadbalance.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data

public class Config {

	@JsonProperty("environments")
	private List<Environment> environments;
	@JsonProperty("projects")
	private List<Project> projects;
	@JsonProperty("ruleTypes")
	private List<RuleType> ruleTypes;
	@JsonProperty("targets")
	private List<Target> targets;
	//@JsonIgnore
	//private List<Pool> pools;
	//@JsonIgnore
	//private List<VirtualHost> virtualhosts;
	
	public Config deserealize(String path) {
		byte[] jsonData;
		try {
			jsonData = Files.readAllBytes(Paths.get("src/main/resources/config.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			Config config = objectMapper.readValue(jsonData, Config.class);
			System.out.println(config);
			return config;
		} catch (IOException e) {
			return null;
		}
		
	}
 	
}
