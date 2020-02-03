package com.valueshark.valueshark.model;

import javax.persistence.*;
import java.sql.Date;
import com.google.gson.Gson;

@Entity
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String symbol;
  private String companyName;
  private String exchange;
  private String industry;
  private String website;
  @Column(columnDefinition="text")
  private String description;
  private String CEO;
  private String sector;
  private String state;
  private String city;
  private String country;
  private int marketcap;
  private double week52high;
  private double week52low;
  private double week52change;
  private int sharesOutstanding;
  private double day200MovingAvg;
  private double day50MovingAvg;
  private double ttmEPS;
  private String nextEarningsDate;
  private double peRatio;
  private double beta;
  private double profitMargin;
  private int enterpriseValue;
  private double priceToBook;
  private double pegRatio;
  private String logoUrl;
  private Date newsDate;
  private String newsHeadline;
  private String newsSource;
  private String newsUrl;
  @Column(columnDefinition="text")
  private String newsSummary;

  public Company() {}

  public Company(long id, String symbol, String companyName, String exchange, String industry, String website, String description, String CEO, String sector, String state, String city, String country, int marketcap, double week52high, double week52low, double week52change, int sharesOutstanding, double day200MovingAvg, double day50MovingAvg, double ttmEPS, String nextEarningsDate, double peRatio, double beta, double profitMargin, int enterpriseValue, double priceToBook, double pegRatio, String logoUrl, Date newsDate, String newsHeadline, String newsSource, String newsUrl, String newsSummary) {
    this.id = id;
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
    this.logoUrl = logoUrl;
    this.newsDate = newsDate;
    this.newsHeadline = newsHeadline;
    this.newsSource = newsSource;
    this.newsUrl = newsUrl;
    this.newsSummary = newsSummary;
  }

  public long getId() {
    return id;
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

  public int getMarketcap() {
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

  public int getSharesOutstanding() {
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

  public int getEnterpriseValue() {
    return enterpriseValue;
  }

  public double getPriceToBook() {
    return priceToBook;
  }

  public double getPegRatio() {
    return pegRatio;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public Date getNewsDate() {
    return newsDate;
  }

  public String getNewsHeadline() {
    return newsHeadline;
  }

  public String getNewsSource() {
    return newsSource;
  }

  public String getNewsUrl() {
    return newsUrl;
  }

  public String getNewsSummary() {
    return newsSummary;
  }
}
