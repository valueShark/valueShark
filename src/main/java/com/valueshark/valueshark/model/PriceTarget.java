package com.valueshark.valueshark.model;

public class PriceTarget {

  private String symbol;
  private String updatedDate;
  private double priceTargetAverage;
  private double priceTargetHigh;
  private double priceTargetLow;
  private long numberOfAnalysts;

  public PriceTarget(String symbol, String updatedDate, double priceTargetAverage, double priceTargetHigh, double priceTargetLow, long numberOfAnalysts) {

    this.symbol = symbol;
    this.updatedDate = updatedDate;
    this.priceTargetAverage = priceTargetAverage;
    this.priceTargetHigh = priceTargetHigh;
    this.priceTargetLow = priceTargetLow;
    this.numberOfAnalysts = numberOfAnalysts;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getUpdatedDate() {
    return updatedDate;
  }

  public double getPriceTargetAverage() {
    return priceTargetAverage;
  }

  public double getPriceTargetHigh() {
    return priceTargetHigh;
  }

  public double getPriceTargetLow() {
    return priceTargetLow;
  }

  public long getNumberOfAnalysts() {
    return numberOfAnalysts;
  }
}
