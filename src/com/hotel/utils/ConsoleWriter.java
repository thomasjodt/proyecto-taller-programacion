package com.hotel.utils;

public class ConsoleWriter {
  private final int LENGTH;

  private ConsoleWriter(int length) {
    this.LENGTH = length;
  }

  public static ConsoleWriter writer;

  public static ConsoleWriter getWriter() {
    return writer;
  }
  public static void setWriter(int length) {
      if (writer == null) {
          writer = new ConsoleWriter(length);
      }
  }

  public void printTopLine() {
    int length = this.LENGTH - 2;
    String linesWithoutCorners = "═".repeat(length);
    System.out.println('╔' + linesWithoutCorners + '╗');
  }

  public void printLineBelow(boolean isLast) {
    int length = this.LENGTH - 2;
    String linesWithoutCorners = "═".repeat(length);

    char leftBottomCorner = (!isLast) ? '╠' : '╚';
    char rightBottomCorner = (!isLast) ? '╣' : '╝';

    System.out.println(leftBottomCorner + linesWithoutCorners + rightBottomCorner);
  }

  public void printContent(String content) {
    this.printContent(content, false);
  }

  public void printContent(String content, boolean isCentered) {
    int length = this.LENGTH - 2;

    String formatted;

    if (isCentered) {
      int leftPadding = (length + content.length()) / 2;
      String format = "%" + leftPadding + "s";
      formatted = String.format(format, content);
    }
    else {
      formatted = " " + content;
    }

    String format = "║%-" + length + "s║%n";
    System.out.printf(format, formatted);
  }

  public void printTitle(String title, boolean isOpenBelow) {
    printTopLine();
    printContent(title, true);
    printLineBelow(!isOpenBelow);
  }

  public void printTitle(String title) {
    this.printTitle(title, false);
  }
}
