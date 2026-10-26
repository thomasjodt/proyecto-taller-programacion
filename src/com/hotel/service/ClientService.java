package com.hotel.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.hotel.model.Cliente;

public class ClientService {
  private final HotelService service;

  public ClientService(HotelService service) {
    this.service = service;
  }

  public ArrayList<Cliente> getClients() {
    return this.service.clients;
  }

  public void addClient(Cliente client) {
    if (client.getId() == null) {
      client.setId(UUID.randomUUID());
    }
    this.service.clients.add(client);
  }

  public Optional<Cliente> findClient(String name) {
    Cliente foundClient = null;
    for (Cliente client : this.service.clients) {
      if (client.getFullName().toLowerCase().contains(name.toLowerCase())) {
        foundClient = client;
        break;
      }
    }
    return Optional.ofNullable(foundClient);
  }

  public void updateClient(Cliente client) {
    Optional<Cliente> o = this.findClient(client.getFullName());

    if (o.isPresent()) {
      int index = this.service.clients.indexOf(o.get());
      this.service.clients.set(index, client);
    }
  }

  public void deleteClient(Cliente client) {
    this.service.clients.remove(client);
  }
}
