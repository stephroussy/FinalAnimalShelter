package com.animal.shelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.animal.shelter.controller.model.StaffDto;
import com.animal.shelter.entity.Staff;
import com.animal.shelter.service.StaffService;

@RestController

public class DefaultStaffController implements StaffController {

  // Default Staff Controller takes information from the Staff Controller and then implements it.
  // Afterwards, it is then handed off to the Staff Service interface.

  @Autowired
  private StaffService staffService;

  // Get (read ALL staff)
  @Override
  public List<Staff> fetchAllStaff() {
    return staffService.fetchAllStaff();
  }

  // Get (read ALL staff with specified last name)

  @Override
  public List<Staff> fetchStaffByLastName(String staffLastName) {
    return staffService.fetchStaffByLastName(staffLastName);
  }

  // Get (read ALL staff with specified staff id)

  @Override
  public List<Staff> fetchStaffByStaffId(Integer staffId) {
    return staffService.fetchStaffByStaffId(staffId);
  }


  // Post (create a staff member)

  @Override
  public Staff createStaff(@Valid StaffDto staffDto) {
    return staffService.createStaff(staffDto.getStaffFirstName(), staffDto.getStaffLastName());
  }

  // Put (update a staff member)

  @Override
  public Staff updateStaff(@Valid StaffDto staffDto) {
    return staffService.updateStaff(staffDto.getStaffId(), staffDto.getStaffFirstName(), 
        staffDto.getStaffLastName());
  }

  // Delete staff

  @Override
  public void deleteStaff(@Valid StaffDto staffDto) {
    staffService.deleteStaff(staffDto.getStaffId());
  }
}
