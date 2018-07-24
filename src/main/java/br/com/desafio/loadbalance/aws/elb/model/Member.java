package br.com.desafio.loadbalance.aws.elb.model;

import lombok.Data;

@Data
public class Member {
	 private String LoadBalancerArn;
	 private String Scheme;
	 private String LoadBalancerName;
	 private String VpcId;
	 private String CanonicalHostedZoneId;
	 private String CreatedTime;
	 AvailabilityZones AvailabilityZonesObject;
	 SecurityGroups SecurityGroupsObject;
	 private String DNSName;
	 State StateObject;
	 private String Type;
}