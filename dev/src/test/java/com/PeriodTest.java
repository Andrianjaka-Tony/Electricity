package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Period;
import com.repository.PeriodRepository;

import lombok.Data;

@SpringBootTest
@Data
public class PeriodTest {

  @Autowired
  private PeriodRepository periodRepository;

  @Test
  void findAllPeriods() {
    System.out.println(Period.findAll(this.getPeriodRepository()));
  }

}
