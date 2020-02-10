package com.valueshark.valueshark;

import com.google.gson.Gson;
import com.valueshark.valueshark.model.PriceTarget;
import com.valueshark.valueshark.model.Symbol;
import com.valueshark.valueshark.model.company.Company;
import com.valueshark.valueshark.model.company.CompanyPrice;
import com.valueshark.valueshark.model.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
public class AdminController {

    @Autowired
    CompanyRepository companyRepo;

    // this is the first time I've seen anyone use this feature, and it's super cool that you were able to get it working!
    @Scheduled(cron= "0 0 0 * * 2-6")
    public void updateDatabase() {

        URL url = null;

        try {
            url = new URL("https://cloud.iexapis.com/stable/ref-data/symbols?token=pk_35f98ba9cfd64a3f86ff6ee241889d5f" );

            Gson gson = new Gson();
            HttpURLConnection con;
            BufferedReader in;

            try {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
                Symbol[] allSymbols = gson.fromJson(in, Symbol[].class);

                //using the symbol, create a new Company and save it in the repo
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(allSymbols.length + " companies found at " + dtf.format(now) + ". Adding the good ones to the Company table.");
                companyRepo.deleteAll();
                int count = 0;
                for (Symbol symbol : allSymbols) {
                    if (symbol.getType().equals("cs")) {

                        try {
                            // grab price targets for each symbol
                            url = new URL("https://cloud.iexapis.com/v1/stock/" + symbol.getSymbol() + "/price-target?token=" + System.getenv("IEXCLOUD_PUSHABLETOKEN"));
                            con = (HttpURLConnection) url.openConnection();
                            con.setRequestMethod("GET");
                            in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                            PriceTarget priceTarget = gson.fromJson(in, PriceTarget.class);
                            in.close();
                            con.disconnect();

                            // grab the price for each symbol
                            // CompanyPrice object used to store data from "quote' endpoint
                            url = new URL("https://cloud.iexapis.com/v1/stock/" + symbol.getSymbol() + "/quote?token=" + System.getenv("IEXCLOUD_PUSHABLETOKEN"));
                            con = (HttpURLConnection) url.openConnection();
                            con.setRequestMethod("GET");
                            in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                            // Send request to "quote" endpoint and store data in coStats
                            CompanyPrice price = gson.fromJson(in, CompanyPrice.class);
                            in.close();
                            con.disconnect();

                            // determine if current price is less than 75% of the average price target
                            if (price.getLatestPrice() < (priceTarget.getPriceTargetAverage() * 0.8)) {

                                // construct a Company if it is
                                Company company = new Company(symbol.getSymbol());
                                System.out.println(symbol.getSymbol() + " has price less than price target");

                                // if the company is a "value stock" save it to DB
                                if (company.getPegRatio() > 0 && company.getPegRatio() < 2 &&
                                    company.getProfitMargin() > 0.1 &&
                                    company.getPriceToBook() > 0 && company.getPriceToBook() < 2 &&
                                    company.getPeRatio() > 0 && company.getPeRatio() < 20 &&
                                    company.getBeta() < 2) {

                                    System.out.println(symbol.getSymbol() + " added to Company table");
                                    companyRepo.save(company);

                                    count++;
                                }

                            }
                        } catch (IOException e) { }

                        //need to slow down requests to avoid 429 "too many requests" errors
                        Thread.sleep(250);
                    }
                }
                System.out.println("Company table updated, " + count + " value stocks added.");

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}