package com.valueshark.valueshark.model.company;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
  Company getBySymbol(String symbol);
  List<Company> findTop20ByOrderByPegRatioAsc();
}
