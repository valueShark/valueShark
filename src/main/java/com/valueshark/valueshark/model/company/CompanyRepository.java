package com.valueshark.valueshark.model.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
  Company getBySymbol(String symbol);
}
