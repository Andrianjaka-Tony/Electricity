package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {

}
