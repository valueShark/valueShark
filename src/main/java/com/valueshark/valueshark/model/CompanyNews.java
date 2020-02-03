package com.valueshark.valueshark.model;

import java.sql.Date;

public class CompanyNews {

  private Date newsDate;
  private String newsHeadline;
  private String newsSource;
  private String newsUrl;
  private String newsSummary;

  public CompanyNews(Date newsDate, String newsHeadline, String newsSource, String newsUrl, String newsSummary) {
    this.newsDate = newsDate;
    this.newsHeadline = newsHeadline;
    this.newsSource = newsSource;
    this.newsUrl = newsUrl;
    this.newsSummary = newsSummary;
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
