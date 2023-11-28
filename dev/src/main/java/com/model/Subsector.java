package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.Column;

@Entity(name = "_subsector")
@Table(name = "_subsector")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subsector {

  @Id
  @GeneratedValue(strategy = SEQUENCE)
  @Column(name = "_id", columnDefinition = "INTEGER", nullable = false, updatable = false, unique = true)
  private Long id;

  @Column(name = "_name", columnDefinition = "VARCHAR", nullable = false, updatable = true, unique = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "_sector", referencedColumnName = "_id")
  private Sector sector;

}
