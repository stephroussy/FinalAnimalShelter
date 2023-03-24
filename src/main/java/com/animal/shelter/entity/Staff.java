package com.animal.shelter.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class Staff {

  private int staffId;

  private String staffFirstName;

  private String staffLastName;

}
