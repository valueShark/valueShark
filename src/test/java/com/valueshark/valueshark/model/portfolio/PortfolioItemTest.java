package com.valueshark.valueshark.model.portfolio;

import com.valueshark.valueshark.model.applicationuser.ApplicationUser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PortfolioItemTest {

    @Test public void testPortfolioItemConstructor() {
        PortfolioItem pi = new PortfolioItem();
        assertNotNull(pi);
    }

//Added assertEquals because this test was not testing for expected values -With Rachael Rice in review
    @Test public void testPortfolioItemGetters() {
        PortfolioItem pi = new PortfolioItem(new ApplicationUser(), new PortfolioCompany(), 1, 1);
        assertNotNull(pi.getUser());
        assertNotNull(pi.getPortfolioCompany());
        assertNotNull(pi.getShares());
        assertNotNull(pi.getPricePerShare());
        assertEquals(1,pi.getShares());
    }

// Added assertEquals because this test was also not actually testing for anything. -With Rachael Rice in review
    @Test public void testPortfolioItemSetters() {
        PortfolioItem pi = new PortfolioItem();
        pi.setUser(new ApplicationUser());
        pi.setPortfolioCompany(new PortfolioCompany());
        pi.setShares(10);
        pi.setPricePerShare(23);
        assertEquals(10, pi.getShares());
    }
}
