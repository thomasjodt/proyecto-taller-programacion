package com.hotel.view.clientes;

import com.hotel.utils.ConsoleCleaner;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

public class MenuClientes {
  private final Prompt prompt = new Prompt();
  private final ConsoleWriter writer = ConsoleWriter.getWriter();

  public void showMenu() {
    while (true) {
      this.printMenu();
      int option = this.prompt.requestInt("Elige una opción:");

      switch (option) {
        case 0:
          ConsoleCleaner.clean();
          writer.printTitle("Regresando al menú principal.");
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
    writer.printTitle("Gestión de Clientes", true);
    writer.printContent("1. Listar clientes registrados.");
    writer.printContent("2. Agregar nuevo cliente.");
    writer.printContent("3. Buscar cliente por nombre.");
    writer.printContent("4. Actualizar datos del cliente.");
    writer.printContent("5. Eliminar cliente."); // Debe solicitar confirmación antes de eliminar.
    writer.printContent("");
    writer.printContent("0. Salir.");
    writer.printLineBelow(true);
  }
}
