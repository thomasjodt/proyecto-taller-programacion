package com.hotel.service;

import java.util.ArrayList;
import com.hotel.model.Integrante;

public class IntegranteService {
  private final ArrayList<Integrante> integrantes = new ArrayList<>();

  public IntegranteService() {
    integrantes.add(new Integrante("Javier Orlando Diaz Torrealva", "U25312187", "Líder del grupo", "Ingeniería de Software"));
    integrantes.add(new Integrante("Juan Arce Morales", "U12345678", "Desarrollador (modelos)", "Ingeniería de Software"));
    integrantes.add(new Integrante("Diego Antonio Alcázar Córdoba", "U12345678", "Desarrollador (servicios)", "Ingeniería de Software"));
    integrantes.add(new Integrante("Blinky", "U12345678", "Desarrollador (créditos)", "Ingeniería de Software"));
    integrantes.add(new Integrante("Clyde", "U12345678", "Desarrollador (vistas)", "Ingeniería de Software"));
  }

  public ArrayList<Integrante> getIntegrantes() {
    return integrantes;
  }

  public Integrante getByName(String name) {
    Integrante i = null;
    for (Integrante integrante: integrantes) {
      if (integrante.getName().toLowerCase().contains(name.toLowerCase())) {
        i = integrante;
        break;
      }
    }

    return i;
  }
}
