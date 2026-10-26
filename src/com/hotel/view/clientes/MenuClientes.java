package com.hotel.view.clientes;

import com.hotel.model.Cliente;
import com.hotel.service.ClientService;
import com.hotel.service.HotelService;
import com.hotel.utils.ConsoleCleaner;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

import java.util.List;
import java.util.Optional;

public class MenuClientes {
  private final Prompt prompt = new Prompt();
  private final ConsoleWriter writer = ConsoleWriter.getWriter();
  private final ClientService service = new ClientService(HotelService.getInstance());

  public void showMenu() {
    while (true) {
      this.printMenu();
      int option = this.prompt.requestInt("Elige una opción:");

      switch (option) {
        case 1:
          ConsoleCleaner.clean();
          this.showClients();
          ConsoleCleaner.clean();
          break;
        case 2:
          ConsoleCleaner.clean();
          this.registerClient();
          ConsoleCleaner.clean();
          break;
        case 3:
          ConsoleCleaner.clean();
          this.findClientByName();
          ConsoleCleaner.clean();
          break;
        case 4:
          ConsoleCleaner.clean();
          this.updateClient();
          ConsoleCleaner.clean();
          break;
        case 5:
          ConsoleCleaner.clean();
          this.deleteClient();
          ConsoleCleaner.clean();
          break;
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
    writer.printContent("5. Eliminar cliente.");
    writer.printContent("");
    writer.printContent("0. Salir.");
    writer.printLineBelow(true);
  }

  private void showClients() {
    List<Cliente> clients = service.getClients();
    writer.printTitle("Lista de clientes registrados", true);

    for (int i = 0; i < clients.size(); i++) {
      Cliente client = clients.get(i);
      writer.printContent((i + 1) + ". " + client.getFullname());
    }

    writer.printLineBelow(true);
    prompt.waitForEnter();
  }

  private void registerClient() {
    Cliente cliente = new Cliente();

    writer.printTitle("Registro de nuevo cliente", false);
    String nombre = prompt.requestText("Ingrese el nombre del cliente:");
    String apellido = prompt.requestText("Ingrese el apellido del cliente:");
    String email = prompt.requestText("Ingrese el email del cliente (opcional):");

    // TODO: Mostrar pantalla de selección de habitación


    cliente.setNames(nombre);
    cliente.setLastnames(apellido);
    cliente.setEmail(email);
    service.addClient(cliente);

  }

  private void findClientByName() {
    writer.printTitle("Buscar cliente", false);
    String clientName = prompt.requestText("Ingrese el nombre del cliente a consultar:");

    Optional<Cliente> client = service.findClient(clientName);
    client.ifPresentOrElse(c -> {
      writer.printTopLine();
      writer.printContent("Cliente encontrado:");
      writer.printContent(c.getFullname());
      writer.printLineBelow(true);
    }, () -> writer.printTitle("Cliente no encontrado"));

    prompt.waitForEnter();
  }

  private void updateClient() {
    writer.printTitle("Actualizar cliente", false);
    String clientName = prompt.requestText("Ingrese el nombre del cliente a actualizar:");

    Optional<Cliente> client = service.findClient(clientName);

    if (client.isEmpty()) {
      writer.printTitle("Cliente no encontrado, regresando al menú.");
      prompt.waitForEnter();
      return;
    }

    Cliente cliente = client.get();
    ConsoleCleaner.clean();
    String nombre = prompt.requestText("Ingrese el nuevo nombre del cliente (vacío para mantener):");
    String apellido = prompt.requestText("Ingrese el nuevo apellido del cliente (vacío para mantener):");
    String email = prompt.requestText("Ingrese el nuevo email del cliente (vacío para mantener):");
    String room = prompt.requestText("Ingrese el nuevo número de habitación del cliente (vacío para mantener):");

    cliente.setNames(!nombre.isEmpty() ? nombre : cliente.getNames());
    cliente.setLastnames(!apellido.isEmpty() ? apellido : cliente.getLastnames());
    cliente.setEmail(!email.isEmpty() ? email : cliente.getEmail());
    cliente.setRoom(!room.isEmpty() ? room : cliente.getRoom());

    ConsoleCleaner.clean();

    boolean isSomePropertyUpdated = !nombre.isEmpty() || !apellido.isEmpty() || !email.isEmpty() || !room.isEmpty();

    writer.printTitle("Cliente actualizado exitosamente.", isSomePropertyUpdated);
    if (!nombre.isEmpty()) {
      writer.printContent("Nombre: " + nombre);
    }

    if (!apellido.isEmpty()) {
      writer.printContent("Apellido: " + apellido);
    }

    if (!email.isEmpty()) {
      writer.printContent("Email: " + email);
    }

    if (!room.isEmpty()) {
      writer.printContent("Habitación: " + room);
    }

    if (isSomePropertyUpdated) {
      writer.printLineBelow(true);
    }

    service.updateClient(cliente);
    prompt.waitForEnter();
  }

  private void deleteClient() {
    writer.printTitle("Eliminar cliente", false);
    String clientName = prompt.requestText("Ingrese el nombre del cliente a eliminar:");

    Optional<Cliente> client = service.findClient(clientName);

    if (client.isEmpty()) {
      writer.printTitle("Cliente no encontrado, regresando al menú.");
      prompt.waitForEnter();
      return;
    }

    Cliente c = client.get();
    writer.printTitle("Cliente: " + c.getFullname());
    boolean isConfirmed = prompt.requestConfirmation("¿Está seguro de que desea eliminar al cliente?");

    if (!isConfirmed) {
      writer.printTitle("Eliminación cancelada.");
      prompt.waitForEnter();
      return;
    }

    service.deleteClient(c);

    writer.printTitle("Cliente eliminado con éxito.");
    prompt.waitForEnter();
  }
}
