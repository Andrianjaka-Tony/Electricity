package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;
import static jakarta.persistence.TemporalType.DATE;

import java.sql.Date;
import java.util.List;

import com.repository.LightIntensityRepository;

@Entity(name = "_light_intensity")
@Table(name = "_light_intensity")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LightIntensity {

  @Id
  @GeneratedValue(strategy = SEQUENCE)
  @Column(name = "_id", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "_time_slot")
  private TimeSlot timeSlot;

  @ManyToOne
  @JoinColumn(name = "_sector")
  private Sector sector;

  @Temporal(DATE)
  @Column(name = "_date", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false, updatable = true, unique = false)
  private Date date;

  @Column(name = "_value", columnDefinition = "NUMERIC", nullable = false, updatable = true, unique = false)
  private Double value;

  public LightIntensity save(LightIntensityRepository lightIntensityRepository) {
    return lightIntensityRepository.save(this);
  }

  public static List<LightIntensity> findAll(LightIntensityRepository lightIntensityRepository) {
    return lightIntensityRepository.findAll();
  }

}
