package com.hotel.utils;

import com.hotel.model.Cliente;
import com.hotel.model.HabitacionEstandar;
import com.hotel.model.Suite;
import com.hotel.service.ClientService;
import com.hotel.service.HotelService;
import com.hotel.service.RoomService;

public class DummyDataGenerator {
  private static final HotelService service = HotelService.getInstance();
  private static final RoomService roomService = new RoomService(service);
  private static final ClientService clientService = new ClientService(service);

  public static void fillClients() {
    clientService.addClient(new Cliente("John", "Doe", ""));
    clientService.addClient(new Cliente("Mateo", "Quispe", ""));
    clientService.addClient(new Cliente("Lucía", "Mamani", ""));
    clientService.addClient(new Cliente("Carlos", "Huamán", ""));
    clientService.addClient(new Cliente("Sofía", "Mendoza", ""));
    clientService.addClient(new Cliente("Diego", "Torres", ""));
    clientService.addClient(new Cliente("Valentina", "Flores", ""));
    clientService.addClient(new Cliente("Gabriel", "Rojas", ""));
    clientService.addClient(new Cliente("Camila", "Castillo", ""));
    clientService.addClient(new Cliente("Alejandro", "Vargas", ""));
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

  // TODO: Implementar método cuando esté listo el módulo de reservaciones.
  public static void fillReservations() {}
}
