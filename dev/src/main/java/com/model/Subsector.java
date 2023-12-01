package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.repository.AttendanceRepository;
import com.repository.SubsectorRepository;

import jakarta.persistence.Column;

@Entity(name = "_subsector")
@Table(name = "_subsector")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subsector {

  @Id
  @SequenceGenerator(name = "_subsector_sequence", sequenceName = "_subsector_sequence", allocationSize = 1)
  @GeneratedValue(strategy = SEQUENCE, generator = "_subsector_sequence")
  @Column(name = "_id", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Long id;

  @Column(name = "_name", columnDefinition = "VARCHAR", nullable = false, updatable = true, unique = false)
  private String name;

  @Column(name = "_individual_consommation", columnDefinition = "NUMERIC", nullable = false, updatable = true, unique = false)
  private Double individualConsommation;

  @ManyToOne
  @JoinColumn(name = "_sector", referencedColumnName = "_id")
  private Sector sector;

  @Transient
  @Builder.Default
  private List<Attendance> attendances = new ArrayList();

  @Transient
  @Builder.Default
  private Double[] avgAttendances = new Double[2];

  public Subsector save(SubsectorRepository subsectorRepository) {
    Subsector response = subsectorRepository.save(this);
    return response;
  }

  public static List<Subsector> findAll(SubsectorRepository subsectorRepository) {
    return subsectorRepository.findAll();
  }

  public static Subsector findById(SubsectorRepository subsectorRepository, Long id) {
    Subsector response = subsectorRepository.findById(id).orElse(null);
    return response;
  }

  public List<Attendance> findAllAttendances(AttendanceRepository attendanceRepository) {
    return attendanceRepository.findBySubsectorId(this.getId());
  }

  public Double getAvgAttendance(SubsectorRepository subsectorRepository, Period period, Date date) {
    return subsectorRepository.getAvgAttendance(this.getId(), period.getId(), date).orElse(0.0);
  }

  public Double[] getAttendancesAvg(SubsectorRepository subsectorRepository, Date date) {
    Double[] response = new Double[2];
    Period am = Period.builder().id(Long.parseLong("1")).build();
    Period pm = Period.builder().id(Long.parseLong("2")).build();
    response[0] = subsectorRepository.getAvgAttendance(this.getId(), am.getId(), date).orElse(0.0);
    response[1] = subsectorRepository.getAvgAttendance(this.getId(), pm.getId(), date).orElse(0.0);
    return response;
  }

  public void syncAvgAttendances(SubsectorRepository subsectorRepository, Date date) {
    this.setAvgAttendances(this.getAttendancesAvg(subsectorRepository, date));
  }

  public Double getConsommationPerHour(Double personNumber) {
    return this.getIndividualConsommation() * personNumber;
  }

  public Double getMorningConsommationPerHour() {
    return this.getConsommationPerHour(this.getAvgAttendances()[0]);
  }

  public Double getAfternoonConsommationPerHour() {
    return this.getConsommationPerHour(this.getAvgAttendances()[1]);
  }

}
