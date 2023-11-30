package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Sector;
import com.repository.SectorRepository;
import com.repository.SubsectorRepository;

import lombok.Getter;

@SpringBootTest
@Getter
public class SectorTest {

  @Autowired
  private SectorRepository sectorRepository;

  @Autowired
  private SubsectorRepository subsectorRepository;

  @Test
  void saveSector() {
    Sector sector = Sector.builder()
        .name("North sector")
        .power(30000.0)
        .battery(10000.0)
        .build();
    System.out.println(sector.save(this.getSectorRepository()));
  }

  @Test
  void findAllSectors() {
    System.out.println(Sector.findAll(this.getSectorRepository()));
  }

  @Test
  void findSectorById() {
    Long id = Long.parseLong("1");
    System.out.println(Sector.findById(this.getSectorRepository(), id));
  }

  @Test
  void findSubsectorsById() {
    Long id = Long.parseLong("1");
    Sector sector = Sector.findById(this.getSectorRepository(), id);
    System.out.println(sector.findAllSubsectors(this.getSubsectorRepository()));
  }

}
