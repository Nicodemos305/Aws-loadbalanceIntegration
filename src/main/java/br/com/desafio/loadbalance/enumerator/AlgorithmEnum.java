package br.com.desafio.loadbalance.enumerator;

public enum AlgorithmEnum {

	ROUND_ROBIN("ROUND_ROBIN");

	public String nomeAlgoritimo;

	AlgorithmEnum(String nomeAlgoritimo) {
		this.nomeAlgoritimo = nomeAlgoritimo;
	}
}
