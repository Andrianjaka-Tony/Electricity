package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.List;

import com.repository.TimeSlotRepository;

@Entity(name = "_time_slot")
@Table(name = "_time_slot")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {

  @Id
  @SequenceGenerator(name = "_time_slot_sequence", sequenceName = "_time_slot_sequence", allocationSize = 1)
  @GeneratedValue(strategy = SEQUENCE, generator = "_time_slot_sequence")
  @Column(name = "_id", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Long id;

  @Column(name = "_begin", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Integer begin;

  @Column(name = "_end", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Integer end;

  @ManyToOne
  @JoinColumn(name = "_period", referencedColumnName = "_id")
  private Period period;

  public static List<TimeSlot> findAll(TimeSlotRepository timeSlotRepository) {
    return timeSlotRepository.findAll();
  }

  public static List<TimeSlot> findByPeriodId(TimeSlotRepository timeSlotRepository, Long periodId) {
    return timeSlotRepository.findByPeriodId(periodId);
  }

}
