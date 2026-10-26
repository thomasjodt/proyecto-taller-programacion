package com.hotel.view;

import com.hotel.utils.ConsoleWriter;

public class MenuPrincipal {
  private final ConsoleWriter writer;

  public MenuPrincipal() {
      this.writer = ConsoleWriter.getWriter();
  }

  public void showMenu() {
    writer.printTitle("Hotel infinito", true);
    writer.printContent("Elige una opción para continuar:");
    writer.printContent("");
    writer.printContent("1. Administrar habitaciones.");
    writer.printContent("2. Administrar clientes.");
    writer.printContent("3. Administrar reservas.");
    writer.printContent("4. Créditos.");
    writer.printContent("0. Salir.");
    writer.printContent("");
    writer.printLineBelow(true);
  }
}
