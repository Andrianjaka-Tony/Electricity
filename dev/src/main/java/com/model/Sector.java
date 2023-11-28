package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;

import com.repository.SectorRepository;
import com.repository.SubsectorRepository;

@Entity(name = "_sector")
@Table(name = "_sector")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sector {

  @Id
  @GeneratedValue(strategy = SEQUENCE)
  @Column(name = "_id", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Long id;

  @Column(name = "_name", columnDefinition = "VARCHAR", nullable = false, updatable = true, unique = false)
  private String name;

  @Column(name = "_power", columnDefinition = "NUMERIC", nullable = false, updatable = true, unique = false)
  private Double power;

  @Column(name = "_battery", columnDefinition = "NUMERIC", nullable = false, updatable = true, unique = false)
  private Double battery;

  @Transient
  @Builder.Default
  private List<Subsector> subsectors = new ArrayList<>();

  public Sector save(SectorRepository sectorRepository) {
    return sectorRepository.save(this);
  }

  public static List<Sector> findAll(SectorRepository sectorRepository) {
    return sectorRepository.findAll();
  }

  public static Sector findById(SectorRepository sectorRepository, Long id) {
    return sectorRepository.findById(id).orElse(null);
  }

  public List<Subsector> findAllSubsectors(SubsectorRepository subsectorRepository) {
    return subsectorRepository.findBySectorId(this.getId());
  }

}
