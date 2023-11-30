package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.LightIntensity;

@Repository
public interface LightIntensityRepository extends JpaRepository<LightIntensity, Long> {

  List<LightIntensity> findBySectorId(Long id);

}
