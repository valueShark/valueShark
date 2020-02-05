package com.valueshark.valueshark;


import com.valueshark.valueshark.model.applicationuser.ApplicationUser;
import com.valueshark.valueshark.model.applicationuser.ApplicationUserRepository;
import com.valueshark.valueshark.model.company.Company;
import com.valueshark.valueshark.model.company.CompanyRepository;
import com.valueshark.valueshark.model.portfolio.PortfolioCompany;
import com.valueshark.valueshark.model.portfolio.PortfolioCompanyRepository;
import com.valueshark.valueshark.model.portfolio.PortfolioItem;
import com.valueshark.valueshark.model.portfolio.PortfolioItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
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
    PortfolioItemRepository portfolioItemRepository;

    @Autowired
    PortfolioCompanyRepository portfolioCompanyRepository;

    @GetMapping("/")
    public String renderHomePage(Principal p, Model m){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);

            //all "value stocks"
            List<Company> allCompanies = companyRepository.findAll();
            m.addAttribute("allCompanies", allCompanies);
        }
        return "index";
    }

    // render specific stocks based on search bar
//    @GetMapping("/")
//    public RedirectView getSpecificStock(){
//        Long id = StocksRepo.findByCompanyName().getId();
//        return new RedirectView("/stocks/" + id);
//    }

    @GetMapping("/signup")
    public String renderSignUpPage(Principal p, Model m){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView submitSignUp(String username, String password, String firstName, String lastName, String email){
        if (applicationUserRepository.findByUsername(username) != null) {
            return new RedirectView("/signup?taken=true");
        } else {
            // instantiate app user and save to database
            ApplicationUser applicationUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName, email);
            applicationUserRepository.save(applicationUser);

           // auto-login
            Authentication authentication = new UsernamePasswordAuthenticationToken(applicationUser, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new RedirectView("/");
        }
    }

    @GetMapping("/login")
    public String login(Model m, Principal p) {
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "login";
    }

    @GetMapping("/portfolio")
    public String renderPortfolio(Model m, Principal p){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            System.out.println(user.portfolio);
            m.addAttribute("user", user);
        }
        return "portfolio";
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

    @GetMapping("/systemstatus")
    public String getSystemStatus(Model m, Principal p){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "systemstatus";
    }

    @GetMapping("/stocks")
    public String renderStockPage(String symbol, Principal p, Model m){
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("user", user);
        if(companyRepository.getBySymbol(symbol) != null) {
            m.addAttribute("company", companyRepository.getBySymbol(symbol));
        } else {
            Company company = new Company(symbol);
            //the companydetails page needs a database id in order to create portfolio items with
            // the form, so we need to add new Companies to the database before sending the attribute to the front end.
            m.addAttribute("company", company);
        }
        return "companydetails";
    }

    @PostMapping("/portfolio/add/{symbol}")
    public RedirectView addToPortfolio(@PathVariable String symbol, Principal p, long shares, double pricePerShare) {
        // grab the logged in user
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        // instantiate a new company with the given symbol
        PortfolioCompany company = new PortfolioCompany(symbol);
        portfolioCompanyRepository.save(company);
        // add the company to the user's portfolio
        PortfolioItem portfolioItem = new PortfolioItem(user, company, shares, pricePerShare);
        portfolioItemRepository.save(portfolioItem);
        user.portfolio.add(portfolioItem);
        applicationUserRepository.save(user);
        return new RedirectView("/");
    }

}
