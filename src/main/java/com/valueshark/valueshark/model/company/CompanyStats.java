package com.valueshark.valueshark.model.company;

public class CompanyStats {

  private long marketcap;
  private double week52high;
  private double week52low;
  private double week52change;
  private long sharesOutstanding;
  private double day200MovingAvg;
  private double day50MovingAvg;
  private double ttmEPS;
  private String nextEarningsDate;
  private double peRatio;
  private double beta;
  private double profitMargin;
  private double enterpriseValue;
  private double priceToBook;
  private double pegRatio;

  public CompanyStats(long marketcap, double week52high, double week52low, double week52change, int sharesOutstanding, double day200MovingAvg, double day50MovingAvg, double ttmEPS, String nextEarningsDate, double peRatio, double beta, double profitMargin, double enterpriseValue, double priceToBook, double pegRatio) {
    this.marketcap = marketcap;
    this.week52high = week52high;
    this.week52low = week52low;
    this.week52change = week52change;
    this.sharesOutstanding = sharesOutstanding;
    this.day200MovingAvg = day200MovingAvg;
    this.day50MovingAvg = day50MovingAvg;
    this.ttmEPS = ttmEPS;
    this.nextEarningsDate = nextEarningsDate;
    this.peRatio = peRatio;
    this.beta = beta;
    this.profitMargin = profitMargin;
    this.enterpriseValue = enterpriseValue;
    this.priceToBook = priceToBook;
    this.pegRatio = pegRatio;
  }
  public CompanyStats(long marketcap, double week52high, double week52low, double week52change, int sharesOutstanding, double day200MovingAvg, double day50MovingAvg, double ttmEPS, String nextEarningsDate, double peRatio, double beta, double profitMargin, long enterpriseValue, double priceToBook, double pegRatio) {
    this.marketcap = marketcap;
    this.week52high = week52high;
    this.week52low = week52low;
    this.week52change = week52change;
    this.sharesOutstanding = sharesOutstanding;
    this.day200MovingAvg = day200MovingAvg;
    this.day50MovingAvg = day50MovingAvg;
    this.ttmEPS = ttmEPS;
    this.nextEarningsDate = nextEarningsDate;
    this.peRatio = peRatio;
    this.beta = beta;
    this.profitMargin = profitMargin;
    this.enterpriseValue = (double) enterpriseValue;
    this.priceToBook = priceToBook;
    this.pegRatio = pegRatio;
  }

  public long getMarketcap() {
    return marketcap;
  }

  public double getWeek52high() {
    return week52high;
  }

  public double getWeek52low() {
    return week52low;
  }

  public double getWeek52change() {
    return week52change;
  }

  public long getSharesOutstanding() {
    return sharesOutstanding;
  }

  public double getDay200MovingAvg() {
    return day200MovingAvg;
  }

  public double getDay50MovingAvg() {
    return day50MovingAvg;
  }

  public double getTtmEPS() {
    return ttmEPS;
  }

  public String getNextEarningsDate() {
    return nextEarningsDate;
  }

  public double getPeRatio() {
    return peRatio;
  }

  public double getBeta() {
    return beta;
  }

  public double getProfitMargin() {
    return profitMargin;
  }

  public double getEnterpriseValue() {
    return (double) enterpriseValue;
  }

  public double getPriceToBook() {
    return priceToBook;
  }

  public double getPegRatio() {
    return pegRatio;
  }
}
