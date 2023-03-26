package com.animal.shelter.service;

import java.util.List;
import com.animal.shelter.entity.DogStaff;


public interface DogStaffService {

  // Get (read ALL dogs with staff)

  List<DogStaff> fetchAllDogStaff();

  // Put (update dogs with staff)

  DogStaff updateDogStaff(int dogId, int staffId);

  // Get dogs by staff id

  List<DogStaff> fetchDogsByStaffId(int staffId);

}
