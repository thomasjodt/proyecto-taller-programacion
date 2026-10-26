package com.hotel.service;

import com.hotel.model.Cliente;
import com.hotel.model.Habitacion;
import com.hotel.model.Reserva;

import java.util.ArrayList;

public class HotelService {
  public ArrayList<Cliente> clients;
  public ArrayList<Reserva> reservas;
  public ArrayList<Habitacion> habitaciones;

  private static HotelService instance;

  private HotelService() {}

  public static HotelService getInstance() {
    if (instance == null) {
      instance = new HotelService();
    }
    return instance;
  }
}
