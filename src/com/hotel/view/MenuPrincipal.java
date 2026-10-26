package com.hotel.view;

import com.hotel.utils.ConsoleCleaner;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

public class MenuPrincipal {
  private final Prompt prompt = new Prompt();
  private final ConsoleWriter writer = ConsoleWriter.getWriter();

  private final Credits credits = new Credits();

  public void showMenu() {
    while (true) {
      this.printMenu();
      int option = prompt.requestInt("Elige una opción: ");

      switch (option) {
        case 4:
          ConsoleCleaner.clean();
          this.credits.showCredits();
          ConsoleCleaner.clean();
          break;
        case 0:
          ConsoleCleaner.clean();
          writer.printTitle("Gracias por usar el sistema, finalizando.");
          prompt.waitForEnter();
          return;
        default:
          ConsoleCleaner.clean();
          System.out.println("Opción no válida, elige una opción disponible en la lista.");
          prompt.waitForEnter();
          break;
      }
    }
  }

  private void printMenu() {
    ConsoleCleaner.clean();
    writer.printTitle("Hotel infinito");
    writer.printTopLine();
    writer.printContent("Elige una opción para continuar:");
    writer.printContent("");
    writer.printContent("1. Administrar habitaciones.");
    writer.printContent("2. Administrar clientes.");
    writer.printContent("3. Administrar reservas.");
    writer.printContent("4. Créditos.");
    writer.printContent("");
    writer.printContent("0. Salir.");
    writer.printLineBelow(true);
  }
}
