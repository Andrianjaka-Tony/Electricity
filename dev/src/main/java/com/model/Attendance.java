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

import com.repository.AttendanceRepository;

@Entity(name = "_attendance")
@Table(name = "_attendance")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

  @Id
  @GeneratedValue(strategy = SEQUENCE)
  @Column(name = "_id", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Long id;

  @Column(name = "_number", columnDefinition = "INTEGER", nullable = false, updatable = true, unique = false)
  private Integer number;

  @Temporal(DATE)
  @Column(name = "_date", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false, updatable = true, unique = false)
  private Date date;

  @ManyToOne
  @JoinColumn(name = "_subsector")
  private Subsector subsector;

  @ManyToOne
  @JoinColumn(name = "_period")
  private Period period;

  public Attendance save(AttendanceRepository attendanceRepository) {
    return attendanceRepository.save(this);
  }

  public static List<Attendance> findAll(AttendanceRepository attendanceRepository) {
    return attendanceRepository.findAll();
  }

}
