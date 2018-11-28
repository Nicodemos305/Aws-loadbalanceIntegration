package br.com.desafio.loadbalance.service;

class CredentialScope {
  static final String TERMINATION_STRING = "aws4_request";

  private final String dateWithoutTimestamp;
  private final String service;
  private final String region;

  public CredentialScope(String dateWithoutTimestamp, String service, String region) {
      super();
      this.dateWithoutTimestamp = dateWithoutTimestamp;
      this.service = service;
      this.region = region;
  }

  String getDateWithoutTimestamp() {
      return dateWithoutTimestamp;
  }

  String getService() {
      return service;
  }

  String getRegion() {
      return region;
  }

  String get() {
      return dateWithoutTimestamp + "/" + region + "/" + service + "/" + TERMINATION_STRING;
  }

}
