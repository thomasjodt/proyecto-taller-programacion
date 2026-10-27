package com.hotel.view;

import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

public class Credits {
  private final ConsoleWriter writer = ConsoleWriter.getWriter();
  private final Prompt prompt = new Prompt();

  public void showCredits() {
    printCredits();
    prompt.waitForEnter();
  }

  private void printCredits() {
    writer.printTopLine();
    writer.printContent("Créditos", true);
    writer.printContent("(Integrantes del grupo)", true);
    writer.printLineBelow(false);
    writer.printContent("1. Javier Orlando Díaz Torrealva.");
    writer.printContent("2. Juan Arce Morales.");
    writer.printContent("3. Diego Antonio Alcázar Córdova.");
    writer.printContent("4. Blinky.");
    writer.printContent("5. Clyde.");
    writer.printLineBelow(true);
  }
}
