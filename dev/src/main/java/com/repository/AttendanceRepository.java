package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

  List<Attendance> findBySubsectorId(Long subsectorId);

}
