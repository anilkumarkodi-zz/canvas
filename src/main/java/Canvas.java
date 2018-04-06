import exception.InValidInputException;

public class Canvas {
  private final int canvasWidth;
  private final int canvasHeight;
  public String[][] area;
  private final int BORDER_LENGTH = 2;

  public Canvas(int width, int height) throws InValidInputException {
    this.canvasWidth = width + BORDER_LENGTH;
    this.canvasHeight = height + BORDER_LENGTH;
    area = new String[canvasHeight][canvasWidth];
  }
  public int getCanvasWidth() {
    return canvasWidth;
  }

  public int getCanvasHeight() {
    return canvasHeight;
  }

  public String[][] getArea() {
    return this.area;
  }

}
