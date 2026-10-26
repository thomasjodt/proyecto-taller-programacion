package com.hotel.utils;

import com.hotel.model.Cliente;
import com.hotel.model.Habitacion;
import com.hotel.model.HabitacionEstandar;
import com.hotel.model.Suite;
import com.hotel.service.ClientService;
import com.hotel.service.HotelService;
import com.hotel.service.RoomService;

import java.util.UUID;

public class DummyDataGenerator {
  private static final HotelService service = HotelService.getInstance();
  private static final ClientService clientService = new ClientService(service);
  private static final RoomService roomService = new RoomService(service);

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

  public static void fillRooms(int floors, int amountPerFloor) {
    for (int i = 1; i <= floors; i++) {
      for (int j = 1; j <= amountPerFloor; j++) {
        if (j == 10) {
          roomService.addRoom(new Suite(i, j, true));
        }
        else {
          roomService.addRoom(new HabitacionEstandar(i, j, true));
        }
      }
    }
  }
}
