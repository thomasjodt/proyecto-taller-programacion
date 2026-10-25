package com.hotel.utils;

import java.util.Scanner;

public class Prompt {
  private final Scanner scanner;

  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  public void waitForEnter() {
    System.out.print("Presione la tecla ENTER para continuar...");
    this.scanner.nextLine();
  }

  public void printCaret() {
    System.out.print("> ");
  }

  private void printMessage(String message) {
    System.out.println(message);
    this.printCaret();
  }

  public String requestText(String message) {
    this.printMessage(message);
    return this.scanner.nextLine();
  }

  public int requestInt(String message) {
    String text = this.requestText(message);

    while (true) {
      try {
        return Integer.parseInt(text.trim());
      } catch (NumberFormatException e) {
        System.out.println("Dato no válido, vuelve a intentarlo.");
      }
    }
  }

  public double requestDouble(String message) {
    String text = this.requestText(message);

    while (true) {
      try {
        return Double.parseDouble(text.trim());
      } catch (NumberFormatException e) {
        System.out.println("Dato no válido, vuelve a intentarlo.");
      }
    }
  }
}
