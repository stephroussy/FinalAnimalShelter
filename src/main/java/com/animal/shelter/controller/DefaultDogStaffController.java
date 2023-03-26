package com.animal.shelter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.animal.shelter.controller.model.DogStaffDto;
import com.animal.shelter.entity.Clients;
import com.animal.shelter.entity.DogStaff;
import com.animal.shelter.service.DogStaffService;

@RestController

public class DefaultDogStaffController implements DogStaffController {

  @Autowired
  private DogStaffService dogStaffService;

  // Get (read ALL Dogs with Staff)

  @Override
  public List<DogStaff> fetchAllDogStaff() {
    return dogStaffService.fetchAllDogStaff();
  }

  // Put (update dogs corresponding with staff)

  @Override
  public DogStaff updateDogStaff(DogStaffDto dogStaffDto) {
    return dogStaffService.updateDogStaff(dogStaffDto.GetdogId(), dogStaffDto.GetstaffId());
  }

  // Get (read dogs with specified staff id)

  @Override
  public List<DogStaff> fetchDogsByStaffId(int staffId) {
    return dogStaffService.fetchDogsByStaffId(staffId);
  }
}
