package br.com.desafio.loadbalance.aws.elb.model;



	public class CreateLoadBalancerResponse {
		 CreateLoadBalancerResult CreateLoadBalancerResultObject;
		 ResponseMetadata ResponseMetadataObject;
		 private String _xmlns;


		 // Getter Methods 

		 public CreateLoadBalancerResult getCreateLoadBalancerResult() {
		  return CreateLoadBalancerResultObject;
		 }

		 public ResponseMetadata getResponseMetadata() {
		  return ResponseMetadataObject;
		 }

		 public String get_xmlns() {
		  return _xmlns;
		 }

		 // Setter Methods 

		 public void setCreateLoadBalancerResult(CreateLoadBalancerResult CreateLoadBalancerResultObject) {
		  this.CreateLoadBalancerResultObject = CreateLoadBalancerResultObject;
		 }

		 public void setResponseMetadata(ResponseMetadata ResponseMetadataObject) {
		  this.ResponseMetadataObject = ResponseMetadataObject;
		 }

		 public void set_xmlns(String _xmlns) {
		  this._xmlns = _xmlns;
		 }
		}
	

