package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

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

}
