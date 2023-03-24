package com.animal.shelter.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.animal.shelter.entity.Dogs;
import com.animal.shelter.entity.Gender;
import com.animal.shelter.entity.Clients;
import com.animal.shelter.entity.Size;
import com.animal.shelter.service.DogsService;

@RestController

public class DefaultDogsController implements DogsController {

  @Autowired
  private DogsService dogService;

  // Get (read ALL clients)
  @Override
  public List<Dogs> fetchAllDogs() {
    return dogService.fetchAllDogs();
  }

  // Get (read ALL dogs with specified size)

  @Override
  public List<Dogs> fetchDogsBySize(Size size) {
    return dogService.fetchDogsBySize(size);
  }

  // Get (read ALL dogs with specified gender)

  @Override
  public List<Dogs> fetchDogsByGender(Gender gender) {
    return dogService.fetchDogsByGender(gender);
  }


  // Get (read ALL dogs with specified dog id)

  @Override
  public List<Dogs> fetchDogsByDogId(int dogId) {
    return dogService.fetchDogsByDogId(dogId);
  }

  // Post (create dogs)
  @Override
  public Dogs createDogs(String dogName, Gender gender, Date birthday, String breed, Size size,
      int clientId) {
    return dogService.createDogs(dogName, gender, birthday, breed, size, clientId);
  }

  // Put (update dogs)
  @Override
  public Dogs updateDogs(int dogId, String dogName, Gender gender, Date birthday, String breed,
      Size size, int clientId) {
    return dogService.updateDogs(dogId, dogName, gender, birthday, breed, size, clientId);
  }

}
