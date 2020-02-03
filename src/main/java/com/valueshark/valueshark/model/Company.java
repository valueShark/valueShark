package com.valueshark.valueshark.model;

import javax.persistence.*;
import java.sql.Date;

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

  public void setId(long id) {
    this.id = id;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCEO(String CEO) {
    this.CEO = CEO;
  }

  public void setSector(String sector) {
    this.sector = sector;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setMarketcap(int marketcap) {
    this.marketcap = marketcap;
  }

  public void setWeek52high(double week52high) {
    this.week52high = week52high;
  }

  public void setWeek52low(double week52low) {
    this.week52low = week52low;
  }

  public void setWeek52change(double week52change) {
    this.week52change = week52change;
  }

  public void setSharesOutstanding(int sharesOutstanding) {
    this.sharesOutstanding = sharesOutstanding;
  }

  public void setDay200MovingAvg(double day200MovingAvg) {
    this.day200MovingAvg = day200MovingAvg;
  }

  public void setDay50MovingAvg(double day50MovingAvg) {
    this.day50MovingAvg = day50MovingAvg;
  }

  public void setTtmEPS(double ttmEPS) {
    this.ttmEPS = ttmEPS;
  }

  public void setNextEarningsDate(String nextEarningsDate) {
    this.nextEarningsDate = nextEarningsDate;
  }

  public void setPeRatio(double peRatio) {
    this.peRatio = peRatio;
  }

  public void setBeta(double beta) {
    this.beta = beta;
  }

  public void setProfitMargin(double profitMargin) {
    this.profitMargin = profitMargin;
  }

  public void setEnterpriseValue(int enterpriseValue) {
    this.enterpriseValue = enterpriseValue;
  }

  public void setPriceToBook(double priceToBook) {
    this.priceToBook = priceToBook;
  }

  public void setPegRatio(double pegRatio) {
    this.pegRatio = pegRatio;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public void setNewsDate(Date newsDate) {
    this.newsDate = newsDate;
  }

  public void setNewsHeadline(String newsHeadline) {
    this.newsHeadline = newsHeadline;
  }

  public void setNewsSource(String newsSource) {
    this.newsSource = newsSource;
  }

  public void setNewsUrl(String newsUrl) {
    this.newsUrl = newsUrl;
  }

  public void setNewsSummary(String newsSummary) {
    this.newsSummary = newsSummary;
  }

  @Override
  public String toString() {
    return "Company{" +
        "id=" + id +
        ", symbol='" + symbol + '\'' +
        ", companyName='" + companyName + '\'' +
        ", exchange='" + exchange + '\'' +
        ", industry='" + industry + '\'' +
        ", website='" + website + '\'' +
        ", description='" + description + '\'' +
        ", CEO='" + CEO + '\'' +
        ", sector='" + sector + '\'' +
        ", state='" + state + '\'' +
        ", city='" + city + '\'' +
        ", country='" + country + '\'' +
        ", marketcap=" + marketcap +
        ", week52high=" + week52high +
        ", week52low=" + week52low +
        ", week52change=" + week52change +
        ", sharesOutstanding=" + sharesOutstanding +
        ", day200MovingAvg=" + day200MovingAvg +
        ", day50MovingAvg=" + day50MovingAvg +
        ", ttmEPS=" + ttmEPS +
        ", nextEarningsDate='" + nextEarningsDate + '\'' +
        ", peRatio=" + peRatio +
        ", beta=" + beta +
        ", profitMargin=" + profitMargin +
        ", enterpriseValue=" + enterpriseValue +
        ", priceToBook=" + priceToBook +
        ", pegRatio=" + pegRatio +
        ", logoUrl='" + logoUrl + '\'' +
        ", newsDate=" + newsDate +
        ", newsHeadline='" + newsHeadline + '\'' +
        ", newsSource='" + newsSource + '\'' +
        ", newsUrl='" + newsUrl + '\'' +
        ", newsSummary='" + newsSummary + '\'' +
        '}';
  }
}
