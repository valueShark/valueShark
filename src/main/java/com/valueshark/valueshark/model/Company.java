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

  public Company(String symbol) {

  }
}
