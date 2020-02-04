package com.valueshark.valueshark.model;

import com.valueshark.valueshark.model.company.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

  Company apple;

  @Test
  public void companyConstructorTest() {
    // test to ensure all instance variables not null
    apple = new Company("aapl");
    System.out.println(apple);
    assertNotNull(apple.getBeta());
    assertNotNull(apple.getCEO());
    assertNotNull(apple.getCity());
    assertNotNull(apple.getCompanyName());
    assertNotNull(apple.getCountry());
    assertNotNull(apple.getDay50MovingAvg());
    assertNotNull(apple.getDay200MovingAvg());
    assertNotNull(apple.getDescription());
    assertNotNull(apple.getEnterpriseValue());
    assertNotNull(apple.getExchange());
    assertNotNull(apple.getId());
    assertNotNull(apple.getIndustry());
    assertNotNull(apple.getLogoUrl());
    assertNotNull(apple.getMarketcap());
    assertNotNull(apple.getNewsDate());
    assertNotNull(apple.getNewsHeadline());
    assertNotNull(apple.getNewsSource());
    assertNotNull(apple.getNewsSummary());
    assertNotNull(apple.getNewsUrl());
    assertNotNull(apple.getNextEarningsDate());
    assertNotNull(apple.getPegRatio());
    assertNotNull(apple.getPeRatio());
    assertNotNull(apple.getPriceToBook());
    assertNotNull(apple.getProfitMargin());
    assertNotNull(apple.getSector());
    assertNotNull(apple.getSharesOutstanding());
    assertNotNull(apple.getState());
    assertNotNull(apple.getSymbol());
    assertNotNull(apple.getTtmEPS());
    assertNotNull(apple.getWebsite());
    assertNotNull(apple.getWeek52change());
    assertNotNull(apple.getWeek52high());
    assertNotNull(apple.getWeek52low());
  }
}