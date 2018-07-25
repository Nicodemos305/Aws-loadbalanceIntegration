package br.com.desafio.loadbalance.service;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.desafio.loadbalance.aws.elb.model.LoadBalancer;
import br.com.desafio.loadbalance.util.AmazonSignature;
import br.com.desafio.loadbalance.util.Ressources;
import uk.co.lucasweb.aws.v4.signer.HttpRequest;
import uk.co.lucasweb.aws.v4.signer.credentials.AwsCredentials;

@Service
public class LoadBalanceService extends ServiceDefault{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public  String createLoadBalance(LoadBalancer loadBalancer,String signature2) {
		String  retorno = null;
		try {
			
			
			Date dataStamp = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
			
			
		/*
		String url = ressources.getUrlAwsElb().concat(ressources.getCreateLoadBalancer()).
			concat("&Name=").concat(loadBalancer.getName()).concat("&Version= 2015-12-01&").concat("X-Amz-Date=")
			.concat(sdf.format(dataStamp).toString()).concat("Authorization=AWS4-HMAC-SHA256&")
			.concat("Credential=").concat(ressources.getKey()+"/"+sdf2.format(dataStamp)+"/"+ressources.getRegionName()+
			"/"+ressources.getServiceName()).concat("/aws4_request&SignedHeaders=host").concat("Signature=").concat(signature);
	*/
			
			String url = ressources.getUrlAwsElb().concat(ressources.getCreateLoadBalancer()).concat("&Name=")
					.concat(loadBalancer.getName()).concat("&Version=2015-12-01");
			
			String contentSha256 = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
			HttpRequest request = new HttpRequest("GET", new URI(url));
			
			String signature = SignerELB.builder()
			        .awsCredentials(new AwsCredentials(ressources.getKey(), ressources.getSecrectKey()))
			        .header("Host", url)
			        .header("X-Amz-Expires", "60")
			        .header("x-amz-date", sdf.format(dataStamp).toString())
			        .header("x-amz-content-sha256", contentSha256)
			        .buildELB(request, contentSha256)
			        .getSignature();
	
			//CanonicalRequest tes = new CanonicalRequest(service, httpRequest, headers, contentSha256) ;
			//System.out.println(request.);
		

			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization",signature);
	
			HttpEntity<String> request2 = new HttpEntity<String>(headers);
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request2, String.class);
			
		//	restTemplate.patchForObject(url,map,String.class);
		
		}catch(Exception e) {
			logger.error("Erro na camada service",e);
		}
		
		return retorno;
	}
	
	
	public String retornaAssinatura(Ressources Ressources,String date) {
		String signature;

		try {
			signature = AmazonSignature.recoveryAWSassignatureV4(ressources.getSecrectKey(),date,ressources.getRegionName(),ressources.getServiceName());
			return signature;
		} catch (Exception e) {
			logger.error("Impossível gerar chave AWS v4",e);
			return null;
		}
	}
	
}