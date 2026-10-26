package com.hotel.service;

import com.hotel.model.Habitacion;

import java.util.ArrayList;
import java.util.Optional;

public class RoomService {
  private final HotelService service;

  public RoomService(HotelService service) {
    this.service = service;
  }

  public void addRoom(Habitacion room) {
    service.habitaciones.add(room);
  }

  public void setRoomAvailability(int index, boolean availability) {
    this.service.habitaciones.get(index).setAvailable(availability);
  }

  public ArrayList<Habitacion> getAllRooms() {
    return this.service.habitaciones;
  }

  public ArrayList<Habitacion> getAvailableRooms() {
    ArrayList<Habitacion> availableRooms = new ArrayList<>();
    for (Habitacion room : this.service.habitaciones) {
      if (room.isAvailable()) {
        availableRooms.add(room);
      }
    }
    return availableRooms;
  }

  public Optional<Habitacion> findByRoomID(String id) {
    for (Habitacion room : this.service.habitaciones) {
      if (room.getRoomID().equals(id)) {
        return Optional.of(room);
      }
    }
    return Optional.empty();
  }

  public Habitacion getRoom(int index) {
    return this.service.habitaciones.get(index);
  }
}
