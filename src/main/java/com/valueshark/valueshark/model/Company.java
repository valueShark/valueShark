package com.valueshark.valueshark.model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
  private double price;
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
  private long enterpriseValue;
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

  public Company(String symbol) {

    CompanyPrice price;

    try {
      URL url = new URL("https://sandbox.iexapis.com/v1/stock/" + symbol + "/quote?token=Tpk_6eaa26587325492481257c267b6cc67f");
      Gson gson = new Gson();
      HttpURLConnection con;
      BufferedReader in;
      try {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        price = gson.fromJson(in, CompanyPrice.class);
        this.price = price.getLatestPrice();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    CompanyInfo coInfo;

    try {
      URL url = new URL("https://sandbox.iexapis.com/v1/stock/" + symbol + "/company?token=Tpk_6eaa26587325492481257c267b6cc67f");
      Gson gson = new Gson();
      HttpURLConnection con;
      BufferedReader in;
      try {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        coInfo = gson.fromJson(in, CompanyInfo.class);
        this.symbol = coInfo.getSymbol();
        this.companyName = coInfo.getCompanyName();
        this.exchange = coInfo.getExchange();
        this.industry = coInfo.getIndustry();
        this.website = coInfo.getWebsite();
        this.description = coInfo.getDescription();
        this.CEO = coInfo.getCEO();
        this.sector = coInfo.getSector();
        this.state = coInfo.getState();
        this.city = coInfo.getCity();
        this.country = coInfo.getCountry();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    CompanyStats coStats;

    try {
      URL url = new URL("https://sandbox.iexapis.com/v1/stock/" + symbol + "/advanced-stats?token=Tpk_6eaa26587325492481257c267b6cc67f");
      Gson gson = new Gson();
      HttpURLConnection con;
      BufferedReader in;
      try {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        coStats = gson.fromJson(in, CompanyStats.class);
        this.marketcap = coStats.getMarketcap();
        this.week52high = coStats.getWeek52high();
        this.week52low = coStats.getWeek52low();
        this.week52change = coStats.getWeek52change();
        this.sharesOutstanding = coStats.getSharesOutstanding();
        this.day200MovingAvg = coStats.getDay200MovingAvg();
        this.day50MovingAvg = coStats.getDay50MovingAvg();
        this.ttmEPS = coStats.getTtmEPS();
        this.nextEarningsDate = coStats.getNextEarningsDate();
        this.peRatio = coStats.getPeRatio();
        this.beta = coStats.getBeta();
        this.profitMargin = coStats.getProfitMargin();
        this.enterpriseValue = (long) coStats.getEnterpriseValue();
        this.priceToBook = coStats.getPriceToBook();
        this.pegRatio = coStats.getPegRatio();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    CompanyLogo coLogo;

    try {
      URL url = new URL("https://sandbox.iexapis.com/v1/stock/" + symbol + "/logo?token=Tpk_6eaa26587325492481257c267b6cc67f");
      Gson gson = new Gson();
      HttpURLConnection con;
      BufferedReader in;
      try {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        coLogo = gson.fromJson(in, CompanyLogo.class);
        this.logoUrl = coLogo.getUrl();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    CompanyNews[] coNews;

    try {
      URL url = new URL("https://sandbox.iexapis.com/v1/stock/" + symbol + "/news/last/1?token=Tpk_6eaa26587325492481257c267b6cc67f");
      Gson gson = new Gson();
      HttpURLConnection con;
      BufferedReader in;
      try {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        coNews = gson.fromJson(in, CompanyNews[].class);
        if (coNews != null && coNews.length > 0) {
          this.newsDate = new Date(coNews[0].getDatetime());
          this.newsHeadline = coNews[0].getHeadline();
          this.newsSource = coNews[0].getSource();
          this.newsUrl = coNews[0].getUrl();
          this.newsSummary = coNews[0].getSummary();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

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

  public long getEnterpriseValue() {
    return (long) enterpriseValue;
  }

  public void setEnterpriseValue(long enterpriseValue) {
    this.enterpriseValue = (long) enterpriseValue;
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
        ", price=" + price +
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
