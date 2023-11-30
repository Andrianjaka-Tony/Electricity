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

import com.repository.PeriodRepository;
import com.repository.TimeSlotRepository;

@Entity(name = "_period")
@Table(name = "_period")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Period {

  @Id
  @GeneratedValue(strategy = SEQUENCE)
  @Column(name = "_id", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Long id;

  @Column(name = "_name", columnDefinition = "VARCHAR", nullable = false, updatable = true, unique = false)
  private String name;

  @Transient
  @Builder.Default
  private List<TimeSlot> timeSlots = new ArrayList<>();

  public static List<Period> findAll(PeriodRepository periodRepository) {
    return periodRepository.findAll();
  }

  public List<TimeSlot> findAllTimeSlots(TimeSlotRepository timeSlotRepository) {
    return TimeSlot.findByPeriodId(timeSlotRepository, this.getId());
  }

}
