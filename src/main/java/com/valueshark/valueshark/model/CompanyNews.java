package com.valueshark.valueshark.model;

import java.sql.Date;

public class CompanyNews {

  private long datetime;
  private String headline;
  private String source;
  private String url;
  private String summary;

  public CompanyNews(long datetime, String headline, String source, String url, String summary) {
    this.datetime = datetime;
    this.headline = headline;
    this.source = source;
    this.url = url;
    this.summary = summary;
  }

  public long getDatetime() {
    return datetime;
  }

  public String getHeadline() {
    return headline;
  }

  public String getSource() {
    return source;
  }

  public String getUrl() {
    return url;
  }

  public String getSummary() {
    return summary;
  }
}
