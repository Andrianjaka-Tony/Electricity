package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.TimeSlot;
import com.repository.TimeSlotRepository;

import lombok.Data;

@SpringBootTest
@Data
public class TimeSlotTest {

  @Autowired
  private TimeSlotRepository timeSlotRepository;

  @Test
  void findAllTimeSlots() {
    System.out.println(TimeSlot.findAll(this.getTimeSlotRepository()));
  }

  @Test
  void findByPeriodId() {
    Long periodId = Long.parseLong("1");
    System.out.println(TimeSlot.findByPeriodId(this.getTimeSlotRepository(), periodId));
  }

}
