package com.hotel.view;

import com.hotel.service.HotelService;
import com.hotel.service.RoomService;
import com.hotel.utils.ConsoleCleaner;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

public class MenuHabitaciones {
  private final Prompt prompt = new Prompt();
  private final ConsoleWriter writer = ConsoleWriter.getWriter();
  private final RoomService service = new RoomService(HotelService.getInstance());

  public void showMenu() {
    while (true) {
      printMenu();
      int option = prompt.requestInt("Ingrese una opción: ");

      switch (option) {
        case 1:
          ConsoleCleaner.clean();
          this.getAvailableRooms();
          ConsoleCleaner.clean();
          break;
        case 2:
          ConsoleCleaner.clean();
          this.getAllRooms();
          ConsoleCleaner.clean();
          break;
        case 3:
          ConsoleCleaner.clean();
          this.queryRoom();
          ConsoleCleaner.clean();
          break;
        case 0:
          ConsoleCleaner.clean();
          this.writer.printTitle("Regresando al menú principal", false);
          this.prompt.waitForEnter();
          return;
        default:
          ConsoleCleaner.clean();
          System.out.println("Opción no válida, inténtelo de nuevo");
          this.prompt.waitForEnter();
          break;
      }
    }
  }

  private void printMenu() {
    this.writer.printTitle("Menú de habitaciones", true);
    this.writer.printContent("1. Ver habitaciones disponibles.");
    this.writer.printContent("2. Ver todas las habitaciones.");
    this.writer.printContent("3. Consultar habitación.");
    this.writer.printContent("");
    this.writer.printContent("0. Regresar al menú principal");
  }

  private void getAvailableRooms() {}
  private void getAllRooms() {}
  private void queryRoom() {}
}
