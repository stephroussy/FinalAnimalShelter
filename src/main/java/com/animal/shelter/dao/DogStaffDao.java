package com.animal.shelter.dao;

import java.util.List;
import com.animal.shelter.entity.DogStaff;

public interface DogStaffDao {

  // Get (read ALL dogs with staff)

  List<DogStaff> fetchAllDogStaff();

  // Put (update dogs with staff)
  
  DogStaff updateDogStaff(int dogId, int staffId);

}
