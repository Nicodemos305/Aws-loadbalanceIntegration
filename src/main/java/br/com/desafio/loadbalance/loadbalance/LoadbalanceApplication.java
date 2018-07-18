package br.com.desafio.loadbalance.loadbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "br.com.desafio.loadbalance")
public class LoadbalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadbalanceApplication.class, args);
	}
}
