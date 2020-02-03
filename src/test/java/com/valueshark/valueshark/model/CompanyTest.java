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

    try {
      URL url = new URL("https://sandbox.iexapis.com/v1/stock/market/batch?symbols=aapl&types=price,company,advanced-stats,logo,news&last=1&token=Tpk_6eaa26587325492481257c267b6cc67f");
      Gson gson = new Gson();
      HttpURLConnection con;
      BufferedReader in;
      try {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        apple = gson.fromJson(in, Company.class);
        System.out.println(apple.toString());
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }
}