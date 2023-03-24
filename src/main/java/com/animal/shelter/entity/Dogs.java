package com.animal.shelter.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Dogs {

  private int dogId;

  private String dogName;

  private Gender gender;

  private Date birthday;

  private String breed;

  private Size size;

  private int clientId;

}
