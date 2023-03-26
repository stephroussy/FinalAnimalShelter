package com.animal.shelter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.animal.shelter.dao.DogStaffDao;
import com.animal.shelter.entity.DogStaff;

@Service

public class DefaultDogStaffService implements DogStaffService {

  @Autowired
  private DogStaffDao dogStaffDao;

  // Get (read ALL Clients)
  @Transactional(readOnly = true)
  @Override
  public List<DogStaff> fetchAllDogStaff() {
    List<DogStaff> dogStaff = dogStaffDao.fetchAllDogStaff();
    return dogStaff;
  }

  // Put (update clients)
  @Override
  public DogStaff updateDogStaff(int dogId, int staffId) {
    return dogStaffDao.updateDogStaff(dogId, staffId);
  }

  // Get dogs by staff id
  @Transactional(readOnly = true)
  @Override
  public List<DogStaff> fetchDogsByStaffId(int staffId) {
    List<DogStaff> dogStaff = dogStaffDao.fetchDogsByStaffId(staffId);
    return dogStaff;
  }

}
