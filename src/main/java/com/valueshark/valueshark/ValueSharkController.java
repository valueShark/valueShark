package com.valueshark.valueshark;


import com.google.gson.Gson;
import com.valueshark.valueshark.model.PriceTarget;
import com.valueshark.valueshark.model.applicationuser.ApplicationUser;
import com.valueshark.valueshark.model.applicationuser.ApplicationUserRepository;
import com.valueshark.valueshark.model.company.*;
import com.valueshark.valueshark.model.portfolio.PortfolioCompanyRepository;
import com.valueshark.valueshark.model.portfolio.PortfolioItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class ValueSharkController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    PortfolioCompanyRepository portfolioCompanyRepository;

    @GetMapping("/")
    public String renderHomePage(Principal p, Model m){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());

            // update each portfolio stock price
            for(PortfolioItem co : user.getPortfolio()) {
                // only update if last price update more than a day old
                if(co.getPortfolioCompany().getLastPriceUpdate().before(new Date(Calendar.getInstance().getTime().getTime()))) {
                    try {
                        URL url = new URL("https://cloud.iexapis.com/v1/stock/" + co.getPortfolioCompany().getSymbol() + "/quote?token=" + System.getenv("IEXCLOUD_PUSHABLETOKEN"));
                        Gson gson = new Gson();
                        HttpURLConnection con;
                        BufferedReader in;
                        try {

                            // CompanyPrice object used to store data from "quote' endpoint
                            CompanyPrice price;
                            con = (HttpURLConnection) url.openConnection();
                            con.setRequestMethod("GET");
                            in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                            // Send request to "quote" endpoint and store data in coStats
                            price = gson.fromJson(in, CompanyPrice.class);
                            co.getPortfolioCompany().setPrice(price.getLatestPrice());
                            co.getPortfolioCompany().setLastPriceUpdate(new Date(Calendar.getInstance().getTime().getTime()));
                            portfolioCompanyRepository.save(co.getPortfolioCompany());
                            in.close();
                            con.disconnect();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }

            m.addAttribute("user", user);

            //all "value stocks"
            List<Company> allCompanies = companyRepository.findAllByOrderByPegRatioAsc();

            // update each prospective investment price
            for(Company co : allCompanies) {
                if(co.getLastPriceUpdate().before(new Date(Calendar.getInstance().getTime().getTime()))) {
                    try {
                        URL url = new URL("https://cloud.iexapis.com/v1/stock/" + co.getSymbol() + "/quote?token=" + System.getenv("IEXCLOUD_PUSHABLETOKEN"));
                        Gson gson = new Gson();
                        HttpURLConnection con;
                        BufferedReader in;
                        try {

                            // CompanyPrice object used to store data from "quote' endpoint
                            CompanyPrice price;
                            con = (HttpURLConnection) url.openConnection();
                            con.setRequestMethod("GET");
                            in = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                            // Send request to "quote" endpoint and store data in coStats
                            price = gson.fromJson(in, CompanyPrice.class);
                            co.setPrice(price.getLatestPrice());
                            co.setLastPriceUpdate(new Date(Calendar.getInstance().getTime().getTime()));
                            companyRepository.save(co);
                            in.close();
                            con.disconnect();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }

            m.addAttribute("allCompanies", allCompanies);
        }
        return "index";
    }

    @GetMapping("/signup")
    public String renderSignUpPage(Principal p, Model m){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView submitSignUp(String username, String password, String reenter, String firstName, String lastName, String email){
        if (applicationUserRepository.findByUsername(username) != null) {
            return new RedirectView("/signup?taken=true");

            // password reentry check
        } if (!reenter.equals(password)) {
            System.out.println(reenter);
            System.out.println(password);
            return new RedirectView("/signup?reenter=true");
        } else {
            // instantiate app user and save to database
            ApplicationUser applicationUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName, email);
            applicationUserRepository.save(applicationUser);

            // stay logged in after sign up
            Authentication authentication = new UsernamePasswordAuthenticationToken(applicationUser, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new RedirectView("/");
        }
    }

    @GetMapping("/login")
    public String login(Model m, Principal p) {
        return "login";
    }

    @GetMapping("/aboutus")
    public String getAboutUs(Model m, Principal p){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "aboutus";
    }

    @GetMapping("/myprofile")
    public String getProfile(Model m, Principal p){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "myprofile";
    }

    @GetMapping("/stocks")
    public String renderStockPage(String symbol, Principal p, Model m){
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        if(companyRepository.getBySymbol(symbol) != null) {
            m.addAttribute("company", companyRepository.getBySymbol(symbol));
        } else {
            Company company = new Company(symbol);

            if (company.getCompanyName() == null) {
                return "symbolnotfound";
            }
            m.addAttribute("company", company);
        }
        return "companydetails";
    }
}
