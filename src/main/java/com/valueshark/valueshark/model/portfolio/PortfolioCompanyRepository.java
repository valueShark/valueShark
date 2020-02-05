package com.valueshark.valueshark.model.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioCompanyRepository extends JpaRepository<PortfolioCompany, Long> {
  PortfolioCompany getBySymbol(String symbol);
}
