package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Attendance;
import com.model.Period;
import com.model.Subsector;
import com.repository.AttendanceRepository;
import com.repository.PeriodRepository;
import com.repository.SubsectorRepository;

import java.sql.Date;

import lombok.Data;

@SpringBootTest
@Data
public class AttendanceTest {

  @Autowired
  private AttendanceRepository attendanceRepository;

  @Autowired
  private SubsectorRepository subsectorRepository;

  @Autowired
  private PeriodRepository periodRepository;

  @Test
  void save() {
    Subsector subsector = Subsector
        .builder()
        .id(Long.parseLong("1"))
        .build();
    Period period = Period
        .builder()
        .id(Long.parseLong("1"))
        .build();
    Attendance attendance = new Attendance(
        null,
        20,
        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7),
        subsector,
        period);
    System.out.println(attendance.save(this.getAttendanceRepository()));
  }

  @Test
  void findAllAttendances() {
    System.out.println(Attendance.findAll(this.getAttendanceRepository()));
  }

}
