package com.valueshark.valueshark;

import javax.persistence.*;

@Entity
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public ApplicationUser userId;

//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    public Company companyId;

    int shares;
    double pricePerShare;

    PortfolioItem() {};
    PortfolioItem(long userId, long companyId, int shares, double pricePerShare) {

    }

}
