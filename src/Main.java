
import java.util.Arrays;
import java.util.stream.Collectors;
import com.hotel.utils.ConsoleWriter;
import com.hotel.utils.Prompt;
import com.hotel.view.MenuPrincipal;

public class Main {
  public static void main(String[] args) {
      // Captura el valor de la longitud del array de argumentos, si no encuentra uno, usa por defecto 60.
      int length = Arrays.stream(args)
              .filter(arg -> arg.startsWith("--length="))
              .map(arg -> arg.substring("--length=".length()))
              .findFirst()
              .map(Integer::parseInt)
              .orElse(60);

      // No se necesita el writer aquí, pero se llama al método estático para inicializar el writer con la longitud obtenida.
      ConsoleWriter.getWriter(length);
      MenuPrincipal menu = new MenuPrincipal();
      menu.showMenu();
  }
}
