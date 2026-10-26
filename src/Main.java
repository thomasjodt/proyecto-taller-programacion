
import java.util.Arrays;
import java.util.stream.Collectors;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.DummyDataGenerator;
import com.hotel.utils.Prompt;
import com.hotel.view.MenuPrincipal;

public class Main {
  public static void main(String[] args) {
    DummyDataGenerator.fillClients(); // Crea 10 clientes de prueba.
    DummyDataGenerator.fillRooms(10, 10); // Crea 10 pisos con 10 habitaciones cada uno, las habitaciones 10 de cada piso son Suites.

      // Captura el valor de la longitud del array de argumentos, si no encuentra uno, usa por defecto 60.
      int length = Arrays.stream(args)
              .filter(arg -> arg.startsWith("--length="))
              .map(arg -> arg.substring("--length=".length()))
              .findFirst()
              .map(Integer::parseInt)
              .orElse(60);

      // Se establece el writer con la longitud obtenida.
      ConsoleWriter.setWriter(length);
      MenuPrincipal menu = new MenuPrincipal();
      menu.showMenu();
  }
}
