package com.valueshark.valueshark.model;

public class CompanyPrice {

  private double latestPrice;

  public CompanyPrice(double latestPrice) {
    this.latestPrice = latestPrice;
  }

  public double getLatestPrice() {
    return latestPrice;
  }

  @Override
  public String toString() {
    return "CompanyPrice{" +
        "price=" + latestPrice +
        '}';
  }
}
