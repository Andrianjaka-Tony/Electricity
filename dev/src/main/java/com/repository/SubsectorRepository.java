package com.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Subsector;

@Repository
public interface SubsectorRepository extends JpaRepository<Subsector, Long> {

  List<Subsector> findBySectorId(Long id);

  @Query(value = "SELECT _number FROM _attendance_avg WHERE _subsector = :sectorId AND _period = :period AND _day = TO_CHAR(CAST(:referenceDate AS DATE), 'Day')", nativeQuery = true)
  Optional<Double> getAvgAttendance(
      @Param("sectorId") Long sectorId,
      @Param("period") Long periodId,
      @Param("referenceDate") Date date);

}
