package com.animal.shelter.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.animal.shelter.entity.Dogs;
import com.animal.shelter.entity.Gender;
import com.animal.shelter.dao.DogsDao;
import com.animal.shelter.entity.Size;

@Service

public class DefaultDogsService implements DogsService {

  @Autowired
  private DogsDao dogDao;

  // Get (read ALL clients)
  @Transactional(readOnly = true)
  @Override
  public List<Dogs> fetchAllDogs() {
    List<Dogs> dogs = dogDao.fetchAllDogs();
    return dogs;
  }

  // Get (read ALL dogs with specified size)
  @Transactional(readOnly = true)
  @Override
  public List<Dogs> fetchDogsBySize(Size size) {
    List<Dogs> dogs = dogDao.fetchDogsBySize(size);
    return dogs;
  }

  // Get (read ALL dogs with specified gender)
  @Transactional(readOnly = true)
  @Override
  public List<Dogs> fetchDogsByGender(Gender gender) {
    List<Dogs> dogs = dogDao.fetchDogsByGender(gender);
    return dogs;
  }

  // Get (read ALL dogs with specified dog id)
  @Transactional(readOnly = true)
  @Override
  public List<Dogs> fetchDogsByDogId(int dogId) {
    List<Dogs> dogs = dogDao.fetchDogsByDogId(dogId);
    return dogs;
  }

  // Post (create dogs)
  @Override
  public Dogs createDogs(String dogName, Gender gender, Date birthday, String breed, Size size,
      int clientId) {
    return dogDao.createDogs(dogName, gender, birthday, breed, size, clientId);
  }

  // Put (update dogs)
  @Override
  public Dogs updateDogs(int dogId, String dogName, Gender gender, Date birthday, String breed,
      Size size, int clientId) {
    return dogDao.updateDogs(dogId, dogName, gender, birthday, breed, size, clientId);
  }

}
