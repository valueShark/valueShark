package com.valueshark.valueshark;


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

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ValueSharkController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String renderHomePage(Principal p, Model m){
        if (p != null) {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/signup")
    public String renderSignUpPage(){
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
    public String login() {
        return "login";
    }

    @GetMapping("/portfolio")
    public String renderPortfolio(Model m, Principal p){
        m.addAttribute("principal", p);
        return "portfolio";
    }

    @GetMapping("/stocks/{id}")
    public String renderStockPage(){
        return "stock";
    }
}
