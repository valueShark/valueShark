package com.valueshark.valueshark.model.portfolio;

import com.valueshark.valueshark.model.applicationuser.ApplicationUser;
import com.valueshark.valueshark.model.company.Company;

import javax.persistence.*;

@Entity
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public ApplicationUser user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company company;

    long shares;
    double pricePerShare;

    PortfolioItem() {};

    public PortfolioItem(ApplicationUser user, Company company, long shares, double pricePerShare) {
        this.user = user;
        this.company = company;
        this.shares = shares;
        this.pricePerShare = pricePerShare;
    }

    public long getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public Company getCompany() {
        return company;
    }

    public long getShares() {
        return shares;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }
}
