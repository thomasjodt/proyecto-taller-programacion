package com.hotel.view;

import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

public class Credits {
  private final ConsoleWriter writer = ConsoleWriter.getWriter();
  private final Prompt prompt = new Prompt();

  public void showCredits() {
    writer.printTopLine();
    writer.printContent("Créditos", true);
    writer.printContent("(Integrantes del grupo)", true);
    writer.printLineBelow(false);
    writer.printContent("Integrantes del grupo:");
    writer.printContent("");
    writer.printContent("1. Javier Orlando Díaz Torrealva.");
    writer.printContent("2. Juan Arce Morales.");
    writer.printContent("3. Integrante 3.");
    writer.printContent("4. Integrante 4.");
    writer.printContent("5. Integrante 5.");
    writer.printLineBelow(true);

    prompt.waitForEnter();
  }
}
