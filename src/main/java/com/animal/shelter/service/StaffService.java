package com.animal.shelter.service;

import java.util.List;
import com.animal.shelter.entity.Staff;
// every interface is just a list of the set of functions for the Staffs

public interface StaffService {

  // Get (read ALL staff)

  List<Staff> fetchAllStaff();

  // Get (read ALL staff with specified last name)

  List<Staff> fetchStaffByLastName(String staffLastName);

  // Get (read ALL staff with specified staff id)

  List<Staff> fetchStaffByStaffId(Integer staffId);

  // Post (create staff)

  Staff createStaff(String staffFirstName, String staffLastName);

  // Put (update staff)

  Staff updateStaff(Integer staffId, String staffFirstName, String staffLastName);

  // Delete staff

  void deleteStaff(Integer staffId);

}
