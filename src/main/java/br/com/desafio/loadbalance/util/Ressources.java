package br.com.desafio.loadbalance.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * 
 * Classe com os recursos utilizados pela aplicação 
 * 
 * @author felipe.nicodemos
*/
@Component
public class Ressources {

	@Value("${url.elb.amazon}")
	private String UrlAwsElb;
	
	@Value("${aws.action.elb.CreateListener}")
	private String CreateListener;
	
	@Value("${aws.action.elb.CreateLoadBalancer}")
	private String CreateLoadBalancer;
	
	@Value("${aws.action.elb.CreateRule}")
	private String CreateRule;

	@Value("${aws.action.elb.CreateTargetGroup}")
	private String CreateTargetGroup;

	@Value("${aws.action.elb.DeleteListener}")
	private String DeleteListener;

	@Value("${aws.action.elb.DeleteLoadBalancer}")
	private String DeleteLoadBalancer;

	@Value("${aws.action.elb.DeleteRule}")
	private String DeleteRule;
	
	@Value("${aws.action.elb.DeleteTargetGroup}")
	private String DeleteTargetGroup;
	
	@Value("${aws.action.elb.DeregisterTargets}")
	private String DeregisterTargets;

	@Value("${aws.action.elb.DescribeListeners}")
	private String DescribeListeners;
	

	@Value("${aws.action.elb.DescribeLoadBalancerAttributes}")
	private String DescribeLoadBalancerAttributes;

	@Value("${aws.action.elb.DescribeLoadBalancers}")
	private String DescribeLoadBalancers;
	
	@Value("${aws.action.elb.DescribeRules}")
	private String DescribeRules;
	
	@Value("${aws.action.elb.DescribeSSLPolicies}")
	private String DescribeSSLPolicies;
	
	@Value("${aws.action.elb.DescribeTags}")
	private String DescribeTags;
	
	@Value("${aws.action.elb.DescribeTargetGroupAttributes}")
	private String DescribeTargetGroupAttributes;
	
	@Value("${aws.action.elb.DescribeTargetGroups}")
	private String DescribeTargetGroups;
	
	@Value("${aws.action.elb.DescribeTargetHealth}")
	private String DescribeTargetHealth;

	@Value("${aws.action.elb.ModifyListener}")
	private String ModifyListener;
	

	@Value("${aws.action.elb.ModifyLoadBalancerAttributes}")
	private String ModifyLoadBalancerAttributes;
	

	@Value("${aws.action.elb.ModifyTargetGroup}")
	private String ModifyTargetGroup;


	@Value("${aws.action.elb.ModifyTargetGroupAttributes}")
	private String ModifyTargetGroupAttributes;
	


	@Value("${aws.action.elb.RegisterTargets}")
	private String RegisterTargets;
	

	@Value("${aws.action.elb.RemoveTags}")
	private String RemoveTags;

	@Value("${aws.action.elb.SetIpAddressType}")
	private String SetIpAddressType;
	

	@Value("${aws.action.elb.SetRulePriorities}")
	private String SetRulePriorities;
	

	@Value("${aws.action.elb.SetSecurityGroups}")
	private String SetSecurityGroups;
	
	@Value("${serviceName}")
	private String serviceName;

	
	@Value("${regionName}")
	private String regionName;
	
	@Value("${aws.action.elb.SetSubnets}")
	private String SetSubnets;
	
	@Value("${key}")
	private String key;
	
	@Value("${secrectKey}")
	private String secrectKey;
	
	@Value("${msg.erro.controller}")
	private String msgController;
	
	@Value("${msg.erro.service}")
	private String msgService;
	
	@Value("${msg.classe}")
	private String msgClasse;
	
	public String getCreateListener() {
		return CreateListener;
	}

	public void setCreateListener(String createListener) {
		CreateListener = createListener;
	}

	public String getCreateLoadBalancer() {
		return CreateLoadBalancer;
	}

	public void setCreateLoadBalancer(String createLoadBalancer) {
		CreateLoadBalancer = createLoadBalancer;
	}

	public String getCreateRule() {
		return CreateRule;
	}

	public void setCreateRule(String createRule) {
		CreateRule = createRule;
	}

	public String getCreateTargetGroup() {
		return CreateTargetGroup;
	}

	public void setCreateTargetGroup(String createTargetGroup) {
		CreateTargetGroup = createTargetGroup;
	}

	public String getDeleteListener() {
		return DeleteListener;
	}

	public void setDeleteListener(String deleteListener) {
		DeleteListener = deleteListener;
	}

	public String getDeleteLoadBalancer() {
		return DeleteLoadBalancer;
	}

	public void setDeleteLoadBalancer(String deleteLoadBalancer) {
		DeleteLoadBalancer = deleteLoadBalancer;
	}

	public String getDeleteRule() {
		return DeleteRule;
	}

	public void setDeleteRule(String deleteRule) {
		DeleteRule = deleteRule;
	}

	public String getDeleteTargetGroup() {
		return DeleteTargetGroup;
	}

	public void setDeleteTargetGroup(String deleteTargetGroup) {
		DeleteTargetGroup = deleteTargetGroup;
	}

	public String getDeregisterTargets() {
		return DeregisterTargets;
	}

	public void setDeregisterTargets(String deregisterTargets) {
		DeregisterTargets = deregisterTargets;
	}

	public String getDescribeListeners() {
		return DescribeListeners;
	}

	public void setDescribeListeners(String describeListeners) {
		DescribeListeners = describeListeners;
	}

	public String getDescribeLoadBalancerAttributes() {
		return DescribeLoadBalancerAttributes;
	}

	public void setDescribeLoadBalancerAttributes(String describeLoadBalancerAttributes) {
		DescribeLoadBalancerAttributes = describeLoadBalancerAttributes;
	}

	public String getDescribeLoadBalancers() {
		return DescribeLoadBalancers;
	}

	public void setDescribeLoadBalancers(String describeLoadBalancers) {
		DescribeLoadBalancers = describeLoadBalancers;
	}

	public String getDescribeRules() {
		return DescribeRules;
	}

	public void setDescribeRules(String describeRules) {
		DescribeRules = describeRules;
	}

	public String getDescribeSSLPolicies() {
		return DescribeSSLPolicies;
	}

	public void setDescribeSSLPolicies(String describeSSLPolicies) {
		DescribeSSLPolicies = describeSSLPolicies;
	}

	public String getDescribeTags() {
		return DescribeTags;
	}

	public void setDescribeTags(String describeTags) {
		DescribeTags = describeTags;
	}

	public String getDescribeTargetGroupAttributes() {
		return DescribeTargetGroupAttributes;
	}

	public void setDescribeTargetGroupAttributes(String describeTargetGroupAttributes) {
		DescribeTargetGroupAttributes = describeTargetGroupAttributes;
	}

	public String getDescribeTargetGroups() {
		return DescribeTargetGroups;
	}

	public void setDescribeTargetGroups(String describeTargetGroups) {
		DescribeTargetGroups = describeTargetGroups;
	}

	public String getDescribeTargetHealth() {
		return DescribeTargetHealth;
	}

	public void setDescribeTargetHealth(String describeTargetHealth) {
		DescribeTargetHealth = describeTargetHealth;
	}

	public String getModifyListener() {
		return ModifyListener;
	}

	public void setModifyListener(String modifyListener) {
		ModifyListener = modifyListener;
	}

	public String getModifyLoadBalancerAttributes() {
		return ModifyLoadBalancerAttributes;
	}

	public void setModifyLoadBalancerAttributes(String modifyLoadBalancerAttributes) {
		ModifyLoadBalancerAttributes = modifyLoadBalancerAttributes;
	}

	public String getModifyTargetGroup() {
		return ModifyTargetGroup;
	}

	public void setModifyTargetGroup(String modifyTargetGroup) {
		ModifyTargetGroup = modifyTargetGroup;
	}

	public String getModifyTargetGroupAttributes() {
		return ModifyTargetGroupAttributes;
	}

	public void setModifyTargetGroupAttributes(String modifyTargetGroupAttributes) {
		ModifyTargetGroupAttributes = modifyTargetGroupAttributes;
	}

	public String getRegisterTargets() {
		return RegisterTargets;
	}

	public void setRegisterTargets(String registerTargets) {
		RegisterTargets = registerTargets;
	}

	public String getRemoveTags() {
		return RemoveTags;
	}

	public void setRemoveTags(String removeTags) {
		RemoveTags = removeTags;
	}

	public String getSetIpAddressType() {
		return SetIpAddressType;
	}

	public void setSetIpAddressType(String setIpAddressType) {
		SetIpAddressType = setIpAddressType;
	}

	public String getSetRulePriorities() {
		return SetRulePriorities;
	}

	public void setSetRulePriorities(String setRulePriorities) {
		SetRulePriorities = setRulePriorities;
	}

	public String getSetSecurityGroups() {
		return SetSecurityGroups;
	}

	public void setSetSecurityGroups(String setSecurityGroups) {
		SetSecurityGroups = setSecurityGroups;
	}

	public String getSetSubnets() {
		return SetSubnets;
	}

	public void setSetSubnets(String setSubnets) {
		SetSubnets = setSubnets;
	}

	public String getUrlAwsElb() {
		return UrlAwsElb;
	}

	public void setUrlAwsElb(String urlAwsElb) {
		UrlAwsElb = urlAwsElb;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSecrectKey() {
		return secrectKey;
	}

	public void setSecrectKey(String secrectKey) {
		this.secrectKey = secrectKey;
	}

	public String getMsgController() {
		return msgController;
	}

	public void setMsgController(String msgController) {
		this.msgController = msgController;
	}

	public String getMsgService() {
		return msgService;
	}

	public void setMsgService(String msgService) {
		this.msgService = msgService;
	}

	public String getMsgClasse() {
		return msgClasse;
	}

	public void setMsgClasse(String msgClasse) {
		this.msgClasse = msgClasse;
	}
	
}
