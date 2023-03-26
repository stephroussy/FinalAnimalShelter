package com.animal.shelter.controller.model;

import java.util.Date;
import com.animal.shelter.entity.Gender;
import com.animal.shelter.entity.Size;

public class DogsDto {
  
  private int dogId;

  private String dogName;

  private Gender gender;

  private Date birthday;

  private String breed;

  private Size size;

  private Integer clientId;

  public Gender getGender() {
    return gender;
  }

  public String getDogName() {
    return dogName;
  }

  
  public String getBreed() {
    return breed;
  }

  public Integer getClientId() {
    return clientId;
  }

  public Size getSize() {
    return size;
  }

  public Date getBirthday() {
    return birthday;
  }

  public int getDogId() {
    return dogId;
  }

}
