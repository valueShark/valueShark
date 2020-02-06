package com.valueshark.valueshark.model.company;

import com.valueshark.valueshark.model.company.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

  Company apple;
  Company sdfsdf;

  @Test
  public void validCompanyConstructorTest() {
    // test to ensure all instance variables not null
    apple = new Company("aapl");
    System.out.println(apple);
    assertNotNull(apple.getCEO());
    assertNotNull(apple.getCity());
    assertNotNull(apple.getCompanyName());
    assertNotNull(apple.getCountry());
    assertNotNull(apple.getDescription());
    assertNotNull(apple.getExchange());
    assertNotNull(apple.getIndustry());
    assertNotNull(apple.getLogoUrl());
    assertNotNull(apple.getNewsDate());
    assertNotNull(apple.getNewsHeadline());
    assertNotNull(apple.getNewsSource());
    assertNotNull(apple.getNewsSummary());
    assertNotNull(apple.getNewsUrl());
    assertNotNull(apple.getNextEarningsDate());
    assertNotNull(apple.getSector());
    assertNotNull(apple.getState());
    assertNotNull(apple.getSymbol());
    assertNotNull(apple.getWebsite());
  }

  @Test
  public void invalidCompanyConstructorTest() {
    // test to ensure all instance variables not null
    sdfsdf = new Company("sdfsdf");
    System.out.println(sdfsdf);
    assertNull(sdfsdf.getCEO());
    assertNull(sdfsdf.getCity());
    assertNull(sdfsdf.getCompanyName());
    assertNull(sdfsdf.getCountry());
    assertNull(sdfsdf.getDescription());
    assertNull(sdfsdf.getExchange());
    assertNull(sdfsdf.getIndustry());
    assertNull(sdfsdf.getLogoUrl());
    assertNull(sdfsdf.getNewsDate());
    assertNull(sdfsdf.getNewsHeadline());
    assertNull(sdfsdf.getNewsSource());
    assertNull(sdfsdf.getNewsSummary());
    assertNull(sdfsdf.getNewsUrl());
    assertNull(sdfsdf.getNextEarningsDate());
    assertNull(sdfsdf.getSector());
    assertNull(sdfsdf.getState());
    assertNull(sdfsdf.getSymbol());
    assertNull(sdfsdf.getWebsite());
  }
}