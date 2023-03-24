package com.animal.shelter.service;

import java.util.List;
import com.animal.shelter.entity.DogStaff;
import com.animal.shelter.entity.Dogs;
import com.animal.shelter.entity.Staff;


public interface DogStaffService {

  // Get (read ALL dogs with staff)

  List<DogStaff> fetchAllDogStaff();

  // Put (update dogs with staff)

  DogStaff updateDogStaff(int dogId, int staffId);

  // Put (update Clients)


}
