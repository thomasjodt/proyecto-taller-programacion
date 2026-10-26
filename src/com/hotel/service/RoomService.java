package com.hotel.service;

import com.hotel.model.Habitacion;

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
}
