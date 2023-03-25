package com.animal.shelter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.animal.shelter.dao.ClientsDao;
import com.animal.shelter.entity.Clients;

@Service

public class DefaultClientsService implements ClientsService {

  @Autowired
  private ClientsDao clientsDao;

  // Get (read ALL Clients)
  @Transactional(readOnly = true)
  @Override
  public List<Clients> fetchAllClients() {
    List<Clients> clients = clientsDao.fetchAllClients();
    return clients;
  }

  // Get (read ALL clients with specified last name)

  @Transactional(readOnly = true)
  @Override
  public List<Clients> fetchClientsByLastName(String clientLastName) {
    List<Clients> clients = clientsDao.fetchClientsByLastName(clientLastName);
    return clients;
  }

  // Get (read ALL clients with specified client id)

  @Transactional(readOnly = true)
  @Override
  public List<Clients> fetchClientsByClientId(Integer clientId) {
    List<Clients> clients = clientsDao.fetchClientsByClientId(clientId);
    return clients;
  }

  // Post (create new clients)

  @Override
  public Clients createClients(String clientFirstName, String clientLastName, String address) {
    return clientsDao.createClients(clientFirstName, clientLastName, address);
  }

  // Put (update clients)

  public Clients updateClients(Integer clientId, String clientFirstName, String clientLastName,
      String address) {
    return clientsDao.updateClients(clientId, clientFirstName, clientLastName, address);
  }

}
