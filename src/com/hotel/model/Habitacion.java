package com.hotel.model;

public abstract class Habitacion {
  private int floor;
  private int number;
  private double price;
  private boolean isAvailable;

  public Habitacion() {}
  public Habitacion(int floor, int number, boolean isAvailable) {
    this.floor = floor;
    this.number = number;
    this.isAvailable = isAvailable;
  }

  public String getRoomID() {
    String paddedFloor = String.format("%02d", floor);
    String paddedNumber = String.format("%02d", number);
    return paddedFloor + paddedNumber;
  }

  public int getFloor() {
    return floor;
  }

  public void setFloor(int floor) {
    this.floor = floor;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }
}
