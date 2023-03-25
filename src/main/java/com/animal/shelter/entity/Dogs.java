package com.animal.shelter.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Dogs {

  private int dogId;

  private String dogName;

  private Gender gender;

  private Date birthday;

  private String breed;

  private Size size;

  private Integer clientId;

}
