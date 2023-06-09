package com.animal.shelter.service;

import java.util.Date;
import java.util.List;
import com.animal.shelter.entity.Dogs;
import com.animal.shelter.entity.Gender;
import com.animal.shelter.entity.Size;

public interface DogsService {

  // Get (read ALL clients)

  List<Dogs> fetchAllDogs();

  // Get (read ALL dogs with specified size)
  List<Dogs> fetchDogsBySize(Size size);

  // Get (read ALL dogs with specified gender)

  List<Dogs> fetchDogsByGender(Gender gender);

  // Get (read ALL dogs with specified dog id)

  List<Dogs> fetchDogsByDogId(int dogId);

  // Post (create dogs)

  Dogs createDogs(String dogName, Gender gender, Date birthday, String breed, Size size,
      Integer clientId);

  // Put (update dogs)

  Dogs updateDogs(int dogId, String dogName, Gender gender, Date birthday, String breed, Size size,
      Integer clientId);

}
