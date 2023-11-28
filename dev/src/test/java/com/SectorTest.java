package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Sector;
import com.repository.SectorRepository;

import lombok.Getter;

@SpringBootTest
@Getter
public class SectorTest {

  @Autowired
  private SectorRepository sectorRepository;

  @Test
  void saveSector() {
    Sector sector = Sector.builder()
        .name("North sector")
        .power(15000.0)
        .battery(5000.0)
        .build();
    System.out.println(sector.save(this.getSectorRepository()));
  }

}
