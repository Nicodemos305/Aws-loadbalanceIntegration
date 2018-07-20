package br.com.desafio.loadbalance.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Ressources {

	@Value("${url.elb.amazon}")
	private String UrlAwsElb;

	public String getUrlAwsElb() {
		return UrlAwsElb;
	}

	public void setUrlAwsElb(String urlAwsElb) {
		UrlAwsElb = urlAwsElb;
	}
	
	
	
}
