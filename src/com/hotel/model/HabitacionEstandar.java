package com.hotel.model;

public class HabitacionEstandar extends Habitacion {
  public HabitacionEstandar() {
    this.setPrice(30);
  }
  public HabitacionEstandar(int floor, int number, boolean isAvailable) {
    super(floor, number, isAvailable);
  }
}
