package utils;

public class ConsoleWriter {
  private final int LENGTH;

  public ConsoleWriter(int length) {
    this.LENGTH = length;
  }

  public void printTopLine() {
    int length = this.LENGTH - 2;
    String lineswithoutCorners = "═".repeat(length);
    System.out.println('╔' + lineswithoutCorners + '╗');
  }

  public void printLineBelow(boolean isLast) {
    int length = this.LENGTH - 2;
    String lineswithoutCorners = "═".repeat(length);

    char leftBottomCorner = (!isLast) ? '╠' : '╚';
    char rightBottomCorner = (!isLast) ? '╣' : '╝';

    System.out.println(leftBottomCorner + lineswithoutCorners + rightBottomCorner);
  }

  public void printContent(String content) {
    this.printContent(content, false);
  }

  public void printContent(String content, boolean isCentered) {
    int length = this.LENGTH - 2;

    String formatted;

    if (isCentered) {
      int leftPadding = (length + content.length()) / 2;
      formatted = String.format("%" + leftPadding + "s", content);
    }
    else {
      formatted = " " + content;
    }

    System.out.printf("║%-" + length + "s║%n", formatted);
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
