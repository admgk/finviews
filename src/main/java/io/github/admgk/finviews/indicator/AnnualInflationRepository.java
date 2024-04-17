package io.github.admgk.finviews.indicator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualInflationRepository extends JpaRepository<AnnualInflation, Integer> {
    
}
