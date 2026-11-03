package br.com.desafio.loadbalance.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafio.loadbalance.util.JsonUtil;
import lombok.Data;

@Data
public class Config  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2383499243592305076L;

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
	
	public static Config deserealize(String path) {
		if (path == null || path.trim().isEmpty()) {
			throw new IllegalArgumentException("O caminho do arquivo de configuração é obrigatório.");
		}
		if (path.contains("/") || path.contains("\\") || path.contains("..")) {
			throw new IllegalArgumentException("Informe apenas o nome de um arquivo de configuração do classpath.");
		}
		try (java.io.InputStream input = Config.class.getClassLoader().getResourceAsStream(path)) {
			if (input == null) throw new IllegalArgumentException("Configuração não encontrada no classpath: " + path);
			ObjectMapper objectMapper = JsonUtil.initJsonMapper();
			return objectMapper.readValue(input, Config.class);
		} catch (IOException e) {
			throw new IllegalArgumentException("Não foi possível ler a configuração em: " + path, e);
		}
	}
 	
}
