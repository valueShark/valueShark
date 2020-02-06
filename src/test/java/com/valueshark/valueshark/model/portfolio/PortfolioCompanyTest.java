package com.valueshark.valueshark.model.portfolio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//these tests require you add a valid api key to the test config env vars
class PortfolioCompanyTest {

  PortfolioCompany validPortfolioCompany;
  PortfolioCompany invalidPortfolioCompany;
  
  @BeforeEach
  void setUp() {
    validPortfolioCompany = new PortfolioCompany("amzn");
    invalidPortfolioCompany = new PortfolioCompany("asdlfkjalsdjf");
  }

  @Test
  public void testValidConstructor() {
    assertNotNull(validPortfolioCompany.getCEO());
    assertNotNull(validPortfolioCompany.getCity());
    assertNotNull(validPortfolioCompany.getCompanyName());
    assertNotNull(validPortfolioCompany.getCountry());
    assertNotNull(validPortfolioCompany.getDescription());
    assertNotNull(validPortfolioCompany.getExchange());
    assertNotNull(validPortfolioCompany.getIndustry());
    assertNotNull(validPortfolioCompany.getLogoUrl());
    assertNotNull(validPortfolioCompany.getNewsDate());
    assertNotNull(validPortfolioCompany.getNewsHeadline());
    assertNotNull(validPortfolioCompany.getNewsSource());
    assertNotNull(validPortfolioCompany.getNewsSummary());
    assertNotNull(validPortfolioCompany.getNewsUrl());
    assertNotNull(validPortfolioCompany.getNextEarningsDate());
    assertNotNull(validPortfolioCompany.getSector());
    assertNotNull(validPortfolioCompany.getState());
    assertNotNull(validPortfolioCompany.getSymbol());
    assertNotNull(validPortfolioCompany.getWebsite());
  }
  
  @Test
  public void testInvalidConstructor() {
    assertNull(invalidPortfolioCompany.getCEO());
    assertNull(invalidPortfolioCompany.getCity());
    assertNull(invalidPortfolioCompany.getCompanyName());
    assertNull(invalidPortfolioCompany.getCountry());
    assertNull(invalidPortfolioCompany.getDescription());
    assertNull(invalidPortfolioCompany.getExchange());
    assertNull(invalidPortfolioCompany.getIndustry());
    assertNull(invalidPortfolioCompany.getLogoUrl());
    assertNull(invalidPortfolioCompany.getNewsDate());
    assertNull(invalidPortfolioCompany.getNewsHeadline());
    assertNull(invalidPortfolioCompany.getNewsSource());
    assertNull(invalidPortfolioCompany.getNewsSummary());
    assertNull(invalidPortfolioCompany.getNewsUrl());
    assertNull(invalidPortfolioCompany.getNextEarningsDate());
    assertNull(invalidPortfolioCompany.getSector());
    assertNull(invalidPortfolioCompany.getState());
    assertNull(invalidPortfolioCompany.getSymbol());
    assertNull(invalidPortfolioCompany.getWebsite());
  }
}