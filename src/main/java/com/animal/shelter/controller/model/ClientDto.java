package com.animal.shelter.controller.model;

public class ClientDto {
  
  private Integer clientId;

  private String clientFirstName;

  private String clientLastName;

  private String address;

  public String getClientFirstName() {
    return clientFirstName;
  }
 
  public String getAddress() {
    return address;
  }

  public String getClientLastName() {
    return clientLastName;
  }

  public Integer getClientId() {
    return clientId;
  }


}
