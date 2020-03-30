package com.valueshark.valueshark.model.portfolio;

import com.valueshark.valueshark.model.applicationuser.ApplicationUser;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

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
    private Date lastPriceUpdate;

    PortfolioItem() {};


    public PortfolioItem(ApplicationUser user, PortfolioCompany portfolioCompany, long shares, double pricePerShare) {
        this.user = user;
        this.portfolioCompany = portfolioCompany;
        this.shares = shares;
        this.pricePerShare = pricePerShare;
        this.lastPriceUpdate = new Date(Calendar.getInstance().getTime().getTime());
    }

    public long getId() {
        return id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public Date getLastPriceUpdate() {
        return lastPriceUpdate;
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

    public void setLastPriceUpdate(Date lastPriceUpdate) {
        this.lastPriceUpdate = lastPriceUpdate;
    }
}
