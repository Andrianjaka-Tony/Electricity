package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Subsector;

@Repository
public interface SubsectorRepository extends JpaRepository<Subsector, Long> {

}
