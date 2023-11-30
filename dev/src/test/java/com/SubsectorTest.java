package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Sector;
import com.model.Subsector;
import com.repository.AttendanceRepository;
import com.repository.SectorRepository;
import com.repository.SubsectorRepository;

import lombok.Data;

@SpringBootTest
@Data
public class SubsectorTest {

  @Autowired
  private SubsectorRepository subsectorRepository;

  @Autowired
  private SectorRepository sectorRepository;

  @Autowired
  private AttendanceRepository attendanceRepository;

  @Test
  void saveSubsector() {
    Long sectorId = Long.parseLong("1");
    Sector sector = Sector.findById(this.getSectorRepository(), sectorId);
    Subsector subsector = Subsector.builder()
        .name("S1 INFO")
        .individualConsommation(Double.parseDouble("80"))
        .sector(sector)
        .build();
    System.out.println(subsector.save(this.getSubsectorRepository()));
  }

  @Test
  void findAllSubsectors() {
    System.out.println(Subsector.findAll(this.getSubsectorRepository()));
  }

  @Test
  void findSubsectorById() {
    Long subsectorId = Long.parseLong("1");
    System.out.println(
        Subsector.findById(this.getSubsectorRepository(), subsectorId));
  }

  @Test
  void findAllAttendancesById() {
    Long subsectorId = Long.parseLong("552");
    Subsector subsector = Subsector.findById(this.getSubsectorRepository(), subsectorId);
    System.out.println(subsector.findAllAttendances(this.getAttendanceRepository()));
  }

}
