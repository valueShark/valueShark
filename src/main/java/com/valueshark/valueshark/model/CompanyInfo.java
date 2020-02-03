package com.valueshark.valueshark.model;

public class CompanyInfo {

  private String symbol;
  private String companyName;
  private String exchange;
  private String industry;
  private String website;
  private String description;
  private String CEO;
  private String sector;
  private String state;
  private String city;
  private String country;

  public CompanyInfo(String symbol, String companyName, String exchange, String industry, String website, String description, String CEO, String sector, String state, String city, String country) {
    this.symbol = symbol;
    this.companyName = companyName;
    this.exchange = exchange;
    this.industry = industry;
    this.website = website;
    this.description = description;
    this.CEO = CEO;
    this.sector = sector;
    this.state = state;
    this.city = city;
    this.country = country;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getExchange() {
    return exchange;
  }

  public String getIndustry() {
    return industry;
  }

  public String getWebsite() {
    return website;
  }

  public String getDescription() {
    return description;
  }

  public String getCEO() {
    return CEO;
  }

  public String getSector() {
    return sector;
  }

  public String getState() {
    return state;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }
}
