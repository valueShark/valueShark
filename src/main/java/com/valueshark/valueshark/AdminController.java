package com.valueshark.valueshark;

import com.google.gson.Gson;
<<<<<<< HEAD
import com.valueshark.valueshark.model.Symbol;
import com.valueshark.valueshark.model.company.Company;
=======
import com.valueshark.valueshark.model.company.Company;
import com.valueshark.valueshark.model.Symbol;
>>>>>>> e18a82e520e26a7229d8d2205eac902de7357da5
import com.valueshark.valueshark.model.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;

@Controller
public class AdminController {
    @Autowired
    CompanyRepository companyRepo;

    @GetMapping("/updateDatabase")
    public String updateDatabase(Principal p) throws MalformedURLException {
//        return early if user is not logged in or not an admin
//        if (p.getName() == null) {
//            return "index";
//        }
        //add check for our usernames here:
//        if (p.getName() == )

        URL url = new URL("https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_6eaa26587325492481257c267b6cc67f");
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
            System.out.println("Adding " + allSymbols.length + " Companies to the Company table.");
            for (Symbol symbol : allSymbols) {
                if (symbol.getType().equals("cs")) {
                    companyRepo.save(new Company(symbol.getSymbol()));
                    System.out.println(symbol.getSymbol() + " added to Company table.");
                    Thread.sleep(250);
                }
            }
            System.out.println("Company table updated!");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "index";
    }
}
