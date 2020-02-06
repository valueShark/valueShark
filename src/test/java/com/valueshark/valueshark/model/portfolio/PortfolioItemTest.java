package com.valueshark.valueshark.model.portfolio;

import com.valueshark.valueshark.model.applicationuser.ApplicationUser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PortfolioItemTest {

    @Test public void testPortfolioItemConstructor() {
        PortfolioItem pi = new PortfolioItem();
        assertNotNull(pi);
    }
    @Test public void testPortfolioItemGetters() {
        PortfolioItem pi = new PortfolioItem(new ApplicationUser(), new PortfolioCompany(), 1, 1);
        assertNotNull(pi.getUser());
        assertNotNull(pi.getPortfolioCompany());
        assertNotNull(pi.getShares());
        assertNotNull(pi.getPricePerShare());
    }
    @Test public void testPortfolioItemSetters() {
        PortfolioItem pi = new PortfolioItem();
        pi.setUser(new ApplicationUser());
        pi.setPortfolioCompany(new PortfolioCompany());
        pi.setShares(10);
        pi.setPricePerShare(23);
    }
}
