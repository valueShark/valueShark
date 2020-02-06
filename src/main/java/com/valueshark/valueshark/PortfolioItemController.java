package com.valueshark.valueshark;

import com.valueshark.valueshark.model.applicationuser.ApplicationUser;
import com.valueshark.valueshark.model.applicationuser.ApplicationUserRepository;
import com.valueshark.valueshark.model.portfolio.PortfolioCompany;
import com.valueshark.valueshark.model.portfolio.PortfolioCompanyRepository;
import com.valueshark.valueshark.model.portfolio.PortfolioItem;
import com.valueshark.valueshark.model.portfolio.PortfolioItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PortfolioItemController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PortfolioCompanyRepository portfolioCompanyRepository;
    @Autowired
    PortfolioItemRepository portfolioItemRepository;

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
        user.getPortfolio().add(portfolioItem);
        applicationUserRepository.save(user);
        return new RedirectView("/");
    }

    @PutMapping("/portfolioItem/{id}/update")
    public RedirectView updatePortfolioItem(@PathVariable Long id, Principal p, Long shares, Double pricePerShare) {
        //get current user and current portfolio item to update
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        PortfolioItem itemToUpdate = portfolioItemRepository.getOne(id);

        //if current user has this portfolio item in their portfolio, update it to new amounts
        if(currentUser.getPortfolio().contains(itemToUpdate)) {
            itemToUpdate.setShares(shares);
            itemToUpdate.setPricePerShare(pricePerShare);
        }
        //save updated portfolio item in repo
        portfolioItemRepository.save(itemToUpdate);

        return new RedirectView("/");
    }

    @DeleteMapping("/portfolioItem/{id}/delete")
    public RedirectView deletePortfolioItem(@PathVariable Long id, Principal p){
        //defining which user wants to delete which portfolio item
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        PortfolioItem itemToDelete = portfolioItemRepository.getOne(id);

        if(currentUser.getPortfolio().contains(itemToDelete)){
            portfolioItemRepository.deleteById(id);
        }

        return new RedirectView("/");

    }

}
