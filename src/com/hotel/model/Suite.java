package com.hotel.model;

import java.util.HashMap;
import java.util.Map;

public class Suite extends Habitacion {
  private final Map<String, Double> extras = new HashMap<>();

  public Suite() {
    this.setPrice(75);
  }
  public Suite(int floor, int number, boolean isAvailable) {
    super(floor, number, isAvailable);
  }

  public void addExtra(String name, double price) {
    this.extras.put(name, price);
  }

  public double getExtrasPrice() {
    return this.extras.values()
      .stream()
      .mapToDouble(Double::doubleValue)
      .sum();
  }
}
