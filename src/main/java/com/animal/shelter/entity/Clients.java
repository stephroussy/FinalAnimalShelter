package com.animal.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Clients {

  // process begins by labeling the different variables within the clients table

  private int clientId;

  private String clientFirstName;

  private String clientLastName;

  private String address;

}
