package com.animal.shelter.service;

import java.util.List;
import com.animal.shelter.entity.Clients;

public interface ClientsService {

  // The service layer takes information from the controller layer,
  // Then the Clients Service interface passes the information to the default clients service.

  // Get (read ALL clients)

  List<Clients> fetchAllClients();

  // Get (read ALL clients with specified last name)

  List<Clients> fetchClientsByLastName(String clientLastName);

  // Get (read ALL clients with specified client id)

  List<Clients> fetchClientsByClientId(int clientId);

  // Post (create clients)

  Clients createClients(String clientFirstName, String clientLastName, String address);

  // Put (update Clients)

  Clients updateClients(int clientId, String clientFirstName, String clientLastName,
      String address);


}
