
import java.util.Arrays;
import java.util.stream.Collectors;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;

public class Main {
  public static void main(String[] args) {
    ConsoleWriter writer = new ConsoleWriter(60);
    Prompt prompt = new Prompt();

    writer.printTitle("Hotel infinito", true);
    writer.printContent("Elige una opción para continuar:");
    writer.printContent("");
    writer.printContent("1. Administrar habitaciones.");
    writer.printContent("2. Administrar clientes.");
    writer.printContent("3. Administrar reservas.");
    writer.printContent("4. Créditos.");
    writer.printContent("0. Salir.");
    writer.printContent("");
    writer.printLineBelow(true);

    String nombre = prompt.requestText("Escribe tus nombres y apellidos:");
    String[] nombres = nombre.split(" ");
    String iniciales = Arrays.stream(nombres)
            .filter(n -> !n.isEmpty())
            .map(n -> n.substring(0, 1))
            .collect(Collectors.joining());

    System.out.println("Tus iniciales son: " + iniciales.toUpperCase());
  }
}
