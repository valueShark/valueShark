package com.valueshark.valueshark.model;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

  Company apple;

  @Test
  public void companyConstructorTest() {

    apple = new Company("aapl");
    System.out.println(apple);

  }
}