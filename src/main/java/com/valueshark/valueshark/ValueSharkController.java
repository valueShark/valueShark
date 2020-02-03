package com.valueshark.valueshark;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ValueSharkController {

    @GetMapping("/")
    public String renderHomePage(){
        return "index";
    }

    @GetMapping("/signup")
    public String renderSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView submitSignUp(String username, String password, String firstName, String lastName){
       return new RedirectView("/");
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
