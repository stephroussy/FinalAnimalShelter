package com.animal.shelter.dao;

import java.util.List;
import com.animal.shelter.entity.Staff;


public interface StaffDao {

  // Get (read ALL Staff)

  List<Staff> fetchAllStaff();

  // Get (read ALL Staff with specified last name)

  List<Staff> fetchStaffByLastName(String staffLastName);

  // Get (read ALL Staff with specified staff id)

  List<Staff> fetchStaffByStaffId(Integer staffId);

  // Post (create Staff)

  Staff createStaff(String staffFirstName, String staffLastName);

  // Put (update Staff)

  Staff updateStaff(Integer staffId, String staffFirstName, String staffLastName);

  // Delete staff

  void deleteStaff(Integer staffId);

}
