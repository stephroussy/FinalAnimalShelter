package com.animal.shelter.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class DogStaff {

  private int dogId;

  private int staffId;

}
