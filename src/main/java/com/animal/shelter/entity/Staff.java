package com.animal.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Staff {

  private int staffId;

  private String staffFirstName;

  private String staffLastName;

}
