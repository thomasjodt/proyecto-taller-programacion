package com.hotel.view;

import com.hotel.model.Habitacion;
import com.hotel.service.HotelService;
import com.hotel.service.RoomService;
import com.hotel.utils.ConsoleCleaner;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

import java.util.ArrayList;
import java.util.Optional;

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
    this.writer.printLineBelow(true);
  }

  private void getAvailableRooms() {
    this.getRooms(true);
  }

  private void getAllRooms() {
    this.getRooms(false);
  }

  private void queryRoom() {
    this.writer.printTitle("Consultar habitación", false);
    String id = this.prompt.requestText("Ingrese el ID de la habitación:");
    Optional<Habitacion> o = this.service.findByRoomID(id);

    if (o.isPresent()) {
      Habitacion room = o.get();
      this.writer.printContent("Habitación encontrada:");
      this.writer.printContent("ID: " + room.getRoomID());
      this.writer.printContent("Disponible: " + room.isAvailable());
    }
    else {
      ConsoleCleaner.clean();
      this.writer.printTitle("Habitación no encontrada.");
    }

    System.out.println();
    this.prompt.waitForEnter();
  }

  private void getRooms(boolean onlyAvailable) {
    ArrayList<Habitacion> rooms = (onlyAvailable)
      ? this.service.getAvailableRooms()
      : this.service.getAllRooms();

    StringBuilder builder = new StringBuilder();
    this.writer.printTitle("Habitaciones disponibles", false);
    this.writer.printTopLine();
    for (int i = rooms.size() - 1; i >= 0; i--) {
      Habitacion room = this.service.getRoom(i);

      String id = (room.isAvailable()) ? room.getRoomID() : "xxxx";

      builder.append("[").append(id).append("]");
      if (room.getNumber() > 1) {
        builder.append(" ");
      }
      else {
        this.writer.printContent(builder.toString());
        builder.setLength(0);
      }
    }
    this.writer.printLineBelow(true);
    System.out.println();
    this.prompt.waitForEnter();
  }
}
