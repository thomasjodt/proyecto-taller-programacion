package com.hotel.view;

import com.hotel.model.Integrante;
import com.hotel.service.IntegranteService;
import com.hotel.utils.ConsoleCleaner;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

import java.util.ArrayList;

public class Credits {
  private final ConsoleWriter writer = ConsoleWriter.getWriter();
  private final Prompt prompt = new Prompt();
  private final IntegranteService service = new IntegranteService();

  public void showCredits() {
    printCredits();
    prompt.waitForEnter();
  }

  private void printCredits() {
    writer.printTopLine();
    writer.printContent("Créditos", true);
    writer.printContent("(Integrantes del grupo)", true);
    writer.printLineBelow(false);

    ArrayList<Integrante> integrantes = service.getIntegrantes();

    for (int i = 0; i < integrantes.size(); i++) {
      Integrante integrante = integrantes.get(i);
      writer.printContent((i + 1) + ". " + integrante.getName());
    }
    writer.printLineBelow(true);

    boolean continueShowing = prompt.requestConfirmation("¿Deseas ver más acerca de un integrante?");
    if (continueShowing) {
      ConsoleCleaner.clean();
      String nombre = prompt.requestText("Ingresa el nombre del integrante que deseas consultar: ");
      Integrante integrante = service.getByName(nombre);

      if (integrante != null) {
        ConsoleCleaner.clean();
        writer.printTopLine();
        writer.printContent("Nombre: " + integrante.getName());
        writer.printContent("Código: " + integrante.getCode());
        writer.printContent("Rol: " + integrante.getRole());
        writer.printContent("Carrera: " + integrante.getCareer());
        writer.printLineBelow(true);
      } else {
        writer.printTitle("No se encontró ningún integrante con ese nombre.", false);
      }
    }
  }
}
