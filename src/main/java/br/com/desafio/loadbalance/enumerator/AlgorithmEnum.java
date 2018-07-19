package br.com.desafio.loadbalance.enumerator;

public enum AlgorithmEnum {

	ROUND_ROBIN("ROUND_ROBIN"),
	WEIGHTED_ROUND_ROBIN("WEIGHTED_ROUND_ROBIN"),
	RANDOM("RANDOM");
	
	public String nomeAlgoritimo;

	AlgorithmEnum(String nomeAlgoritimo) {
		this.nomeAlgoritimo = nomeAlgoritimo;
	}
}
