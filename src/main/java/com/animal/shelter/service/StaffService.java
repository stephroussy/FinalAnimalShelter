package com.animal.shelter.service;

import java.util.List;
import com.animal.shelter.entity.Staff;
// every interface is just a list of the set of functions for the Staffs

public interface StaffService {

  // Get (read ALL Staff)

  List<Staff> fetchAllStaff();

  // Get (read ALL Staff with specified last name)

  List<Staff> fetchStaffByLastName(String staffLastName);

  // Get (read ALL Staff with specified staff id)

  List<Staff> fetchStaffByStaffId(int staffId);

  // Post (create Staff)

  Staff createStaff(String staffFirstName, String staffLastName);

  // Put (update Staff)

  Staff updateStaff(int staffId, String staffFirstName, String staffLastName);

  // Delete staff

  void deleteStaff(int staffId);

}
