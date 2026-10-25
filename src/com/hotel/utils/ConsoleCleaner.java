package com.hotel.utils;

public class ConsoleCleaner {
  public static void clean() {
    clearConsole(50);
  }

  public static void clean(int lines) {
    clearConsole(lines);
  }

  private static void clearConsole(int lines) {
    boolean isConsoleExisting = System.console() != null;

    if (isConsoleExisting) {
      clearConsoleWithSystemCommands();
    }

    else {
      clearConsoleWithBlankLines(lines);
    }
  }

  /**
   * Método para limpiar la consola usando saltos de línea, este método se usa en lugares donde no existe
   * la consola como en el output del IDE, que utiliza `javaw`.
   * @param lines
   */
  private static void clearConsoleWithBlankLines(int lines) {
    for (int i = 0; i < lines; i++) {
      System.out.println();
    }
  }

  /**
   * Utiliza los comandos nativos del sistema operativo para limpiar la consola, solo
   * funciona si el programa es ejecutado desde la terminal.
   *
   * Primero valida si el sistema operativo es Windows para ejecutar comandos específicos, para los demás
   * (basados en Unix) usa directamente `clear`.
   */
  private static void clearConsoleWithSystemCommands() {
    try {
      String system = System.getProperty("os.name");

      if (system.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    }

    catch (Exception e) {
      clearConsoleWithEscapeCharacters();
    }
  }

  /**
   * La secuencia de carácteres `\033` representa el caracter UNICODE de escape (Esc), el cual indica a la terminal
   * que lo que sigue es un comando de control y no texto común.
   * `[H` mueve el cursor a la esquina superior izquierda de la consola (fila 1, columna 1)
   * `[2J` borra el contenido visible de la pantalla de la terminal.
   */
  private static void clearConsoleWithEscapeCharacters() {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }
}
