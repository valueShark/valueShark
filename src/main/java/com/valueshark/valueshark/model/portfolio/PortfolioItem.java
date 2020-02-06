package com.valueshark.valueshark.model.portfolio;

import com.valueshark.valueshark.model.applicationuser.ApplicationUser;

import javax.persistence.*;

@Entity
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ApplicationUser user;

    @ManyToOne
    private PortfolioCompany portfolioCompany;

    private long shares;
    private double pricePerShare;

    PortfolioItem() {};


    public PortfolioItem(ApplicationUser user, PortfolioCompany portfolioCompany, long shares, double pricePerShare) {
        this.user = user;
        this.portfolioCompany = portfolioCompany;
        this.shares = shares;
        this.pricePerShare = pricePerShare;
    }

    public long getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public void setPortfolioCompany(PortfolioCompany portfolioCompany) {
        this.portfolioCompany = portfolioCompany;
    }

    public PortfolioCompany getPortfolioCompany() {
        return portfolioCompany;
    }

    public long getShares() {
        return shares;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public void setShares(long shares) {
        this.shares = shares;
    }

    public void setPricePerShare(double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }
}
