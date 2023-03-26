package com.animal.shelter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.animal.shelter.controller.model.ClientDto;
import com.animal.shelter.entity.Clients;
import com.animal.shelter.service.ClientsService;

@RestController

public class DefaultClientsController implements ClientsController {

  // Default Clients Controller takes information from the Client Controller and then implements it.
  // Afterwards, it is then handed off to the Client Service interface.

  @Autowired
  private ClientsService clientService;

  // Get (read ALL clients)
  @Override
  public List<Clients> fetchAllClients() {
    return clientService.fetchAllClients();
  }

  // Get (read ALL clients with specified last name)

  @Override
  public List<Clients> fetchClientsByLastName(String clientLastName) {
    return clientService.fetchClientsByLastName(clientLastName);
  }

  // Get (read ALL clients with specified client id)

  @Override
  public List<Clients> fetchClientsByClientId(Integer clientId) {
    return clientService.fetchClientsByClientId(clientId);
  }

  // Post (create clients)
  @Override
  public Clients createClients(@Valid ClientDto clientDto) {
    return clientService.createClients(clientDto.getClientFirstName(), clientDto.getClientLastName(), 
        clientDto.getAddress());
  }

  // Put (update Clients)
  @Override
  public Clients updateClients(@Valid ClientDto clientDto) {
    return clientService.updateClients(clientDto.getClientId(), clientDto.getClientFirstName(), 
        clientDto.getClientLastName(), clientDto.getAddress());
  }
}
