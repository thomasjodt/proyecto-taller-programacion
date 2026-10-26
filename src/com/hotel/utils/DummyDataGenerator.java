package com.hotel.utils;

import com.hotel.model.Cliente;
import com.hotel.service.ClientService;
import com.hotel.service.HotelService;

import java.util.UUID;

public class DummyDataGenerator {
  private static final HotelService service = HotelService.getInstance();
  private static final ClientService clientService = new ClientService(service);

  public static void fillClients() {
    clientService.addClient(new Cliente("John", "Doe", "", "207", UUID.randomUUID()));
    clientService.addClient(new Cliente("Mateo", "Quispe", "", "304", UUID.randomUUID()));
    clientService.addClient(new Cliente("Lucía", "Mamani", "", "210", UUID.randomUUID()));
    clientService.addClient(new Cliente("Carlos", "Huamán", "", "202", UUID.randomUUID()));
    clientService.addClient(new Cliente("Sofía", "Mendoza", "", "405", UUID.randomUUID()));
    clientService.addClient(new Cliente("Diego", "Torres", "", "506", UUID.randomUUID()));
    clientService.addClient(new Cliente("Valentina", "Flores", "", "1010", UUID.randomUUID()));
    clientService.addClient(new Cliente("Gabriel", "Rojas", "", "701", UUID.randomUUID()));
    clientService.addClient(new Cliente("Camila", "Castillo", "", "606", UUID.randomUUID()));
    clientService.addClient(new Cliente("Alejandro", "Vargas", "", "809", UUID.randomUUID()));
  }
}
