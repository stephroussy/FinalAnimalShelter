package com.animal.shelter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.animal.shelter.dao.StaffDao;
import com.animal.shelter.entity.Staff;

@Service

public class DefaultStaffService implements StaffService {

  @Autowired
  private StaffDao staffDao;

  // Get (read ALL Staff)
  @Transactional(readOnly = true)
  @Override
  public List<Staff> fetchAllStaff() {
    List<Staff> staff = staffDao.fetchAllStaff();
    return staff;
  }

  // Get (read ALL Staff with specified last name)

  @Transactional(readOnly = true)
  @Override
  public List<Staff> fetchStaffByLastName(String staffLastName) {
    List<Staff> staff = staffDao.fetchStaffByLastName(staffLastName);
    return staff;
  }

  // Get (read ALL Staff with specified staff id)

  @Transactional(readOnly = true)
  @Override
  public List<Staff> fetchStaffByStaffId(int staffId) {
    List<Staff> staff = staffDao.fetchStaffByStaffId(staffId);
    return staff;
  }

  // Post (create new Staff)

  @Override
  public Staff createStaff(String staffFirstName, String staffLastName) {
    return staffDao.createStaff(staffFirstName, staffLastName);
  }


  // Put (update Staff)
  @Override
  public Staff updateStaff(int staffId, String staffFirstName, String staffLastName) {
    return staffDao.updateStaff(staffId, staffFirstName, staffLastName);
  }

  // Delete staff

  @Override
  public void deleteStaff(int staffId) {
    staffDao.deleteStaff(staffId);
  }

}
