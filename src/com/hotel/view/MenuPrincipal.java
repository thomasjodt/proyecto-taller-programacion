package com.hotel.view;

import com.hotel.utils.ConsoleCleaner;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

public class MenuPrincipal {
  private final Prompt prompt = new Prompt();
  private final ConsoleWriter writer = ConsoleWriter.getWriter();

  private final Credits credits = new Credits();
  private final MenuClientes menuClientes = new MenuClientes();
  private final MenuHabitaciones menuHabitaciones = new MenuHabitaciones();

  /**
   * El método principal, que es el que se encarga de mostrar el menú principal y gestionar las opciones seleccionadas por el usuario.
   * Debe ser un bucle infinito que muestra el menú principal y espera a que el usuario seleccione una opción.
   * No hay problema con tener `while(true)` porque se espera que se muestre siempre y el único caso para salir del bucle es `0`, el
   * cual hace que se finalice el programa.
   */
  public void showMenu() {
    while (true) {
      this.printMenu();
      int option = prompt.requestInt("Elige una opción: ");

      // En cada caso se limpia la consola y se muestra el menú de la opción seleccionada.
      // Luego se vuelve a limpiar la consola para que no quede nada de la opción anterior, a excepción de algunos casos.
      // Los casos que no siguen el mismo patrón son `0` para salir y `default` que muestra un mensaje y espera confirmación.
      switch (option) {
        case 1:
          ConsoleCleaner.clean();
          this.menuHabitaciones.showMenu();
          ConsoleCleaner.clean();
          break;
        case 2:
          ConsoleCleaner.clean();
          this.menuClientes.showMenu();
          ConsoleCleaner.clean();
          break;
        case 4:
          ConsoleCleaner.clean();
          this.credits.showCredits();
          ConsoleCleaner.clean();
          break;
        case 0:
          ConsoleCleaner.clean();
          this.writer.printTitle("Gracias por usar el sistema, finalizando.");
          this.prompt.waitForEnter();
          return;
        default:
          ConsoleCleaner.clean();
          System.out.println("Opción no válida, elige una opción disponible en la lista.");
          this.prompt.waitForEnter();
          break;
      }
    }
  }

  private void printMenu() {
    ConsoleCleaner.clean();
    this.writer.printTitle("Hotel infinito");
    this.writer.printTopLine();
    this.writer.printContent("Elige una opción para continuar:");
    this.writer.printContent("");
    this.writer.printContent("1. Administrar habitaciones.");
    this.writer.printContent("2. Administrar clientes.");
    this.writer.printContent("3. Administrar reservas.");
    this.writer.printContent("4. Créditos.");
    this.writer.printContent("");
    this.writer.printContent("0. Salir.");
    this.writer.printLineBelow(true);
  }
}
