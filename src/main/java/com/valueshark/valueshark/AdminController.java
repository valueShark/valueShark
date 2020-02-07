package com.valueshark.valueshark;

import com.google.gson.Gson;
import com.valueshark.valueshark.model.company.Company;
import com.valueshark.valueshark.model.Symbol;
import com.valueshark.valueshark.model.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.concurrent.Callable;

@Configuration
@EnableScheduling
public class AdminController {

    @Autowired
    CompanyRepository companyRepo;

    @Scheduled(cron= "0 0 0 * * *")
    public void updateDatabase() {

        URL url = null;

        try {
            url = new URL("https://cloud.iexapis.com/stable/ref-data/symbols?token=" + System.getenv("IEXCLOUD_PUSHABLETOKEN"));

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
                System.out.println(allSymbols.length + " companies found. Adding the good ones to the Company table.");
                companyRepo.deleteAll();
                int count = 0;
                for (Symbol symbol : allSymbols) {
                    if (symbol.getType().equals("cs")) {
                        count++;
                        Company company = new Company(symbol.getSymbol());

                        System.out.println("\nCreated company: " + symbol.getSymbol());

//                    if the company is a "value stock" save it to DB
                        if (company.getPegRatio() > 0 && company.getPegRatio() < 2 &&
                            company.getProfitMargin() > 0.1 &&
                            company.getPriceToBook() > 0 && company.getPriceToBook() < 2 &&
                            company.getPeRatio() > 0 && company.getPeRatio() < 20 &&
                            company.getBeta() < 2) {

                            System.out.println(symbol.getSymbol() + " added to Company table.");
                            companyRepo.save(company);
                        }

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