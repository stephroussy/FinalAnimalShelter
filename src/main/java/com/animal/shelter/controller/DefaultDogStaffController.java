package com.animal.shelter.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.animal.shelter.entity.DogStaff;
import com.animal.shelter.entity.Dogs;
import com.animal.shelter.entity.Staff;
import com.animal.shelter.service.DogStaffService;
import lombok.extern.slf4j.Slf4j;

@RestController

public class DefaultDogStaffController implements DogStaffController {

  @Autowired
  private DogStaffService dogStaffService;

  @Override
  public List<DogStaff> fetchAllDogStaff() {
    return dogStaffService.fetchAllDogStaff();
  }

  @Override
  public DogStaff updateDogStaff(int dogId, int staffId) {
    return dogStaffService.updateDogStaff(dogId, staffId);
  }

  @Override
  public List<DogStaff> fetchDogsByStaffId(int staffId) {
    // TODO Auto-generated method stub
    return null;
  }
}
