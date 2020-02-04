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
    public ApplicationUser userId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company companyId;

    int shares;
    double pricePerShare;

    PortfolioItem() {};

    public PortfolioItem(ApplicationUser userId, Company companyId, int shares, double pricePerShare) {
        this.userId = userId;
        this.companyId = companyId;
        this.shares = shares;
        this.pricePerShare = pricePerShare;
    }

    public long getId() {
        return id;
    }

    public ApplicationUser getUserId() {
        return userId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public int getShares() {
        return shares;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }
}
