package com;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.LightIntensity;
import com.model.Sector;
import com.model.TimeSlot;
import com.repository.LightIntensityRepository;

import lombok.Data;

@SpringBootTest
@Data
public class LightIntensityTest {

  @Autowired
  private LightIntensityRepository lightIntensityRepository;

  @Test
  void saveLightIntensity() {
    TimeSlot timeSlot = TimeSlot
        .builder()
        .id(Long.parseLong("1"))
        .build();
    Sector sector = Sector
        .builder()
        .id(Long.parseLong("1"))
        .build();
    LightIntensity lightIntensity = LightIntensity
        .builder()
        .timeSlot(timeSlot)
        .sector(sector)
        .value(Double.parseDouble("7"))
        .date(new Date(System.currentTimeMillis()))
        .build();
    System.out.println(lightIntensity.save(this.getLightIntensityRepository()));
  }

  @Test
  void findAll() {
    System.out.println(LightIntensity.findAll(this.getLightIntensityRepository()));
  }

}
