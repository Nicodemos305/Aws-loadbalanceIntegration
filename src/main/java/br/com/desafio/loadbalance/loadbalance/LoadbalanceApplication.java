package br.com.desafio.loadbalance.loadbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "br.com.desafio.loadbalance")
@EnableAutoConfiguration
@SpringBootApplication
public class LoadbalanceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(LoadbalanceApplication.class, args);
	}
	
	
}
