import exception.InValidInputException;
import java.util.Arrays;

public class Canvas implements Operations {
  
  private final int canvasWidth;
  private final int canvasHeight;
  private String[][] canvasArea;
  
  public Canvas(int width, int height) {
    this.canvasWidth = width + 2;
    this.canvasHeight = height + 2;
    canvasArea = new String[canvasHeight][canvasWidth];
  }
  
  @Override
  public String[][] create() throws InValidInputException {
    canvasArea = new String[canvasHeight][canvasWidth];
    prepare();
    final int canvasStart = 0;
    String symbol = "-\t";
    drawRows(canvasStart, canvasStart, canvasWidth, symbol);
    drawRows(canvasHeight - 1, canvasStart, canvasWidth, symbol);
    drawColumnsForGivenRow(canvasStart, canvasStart, canvasHeight - 1, symbol);
    drawColumnsForGivenRow(canvasWidth - 1, canvasStart, canvasHeight - 1, symbol);
    return canvasArea;
  }

  @Override
  public String[][] drawLine(int x1, int y1, int x2, int y2) throws InValidInputException {
    if (y1 == y2) {
      drawRows(y1, x1, x2 + 1, "*\t");
    } else if (x1 == x2) {
      drawColumnsForGivenRow(x1, y1, y2 + 1, "*\t");
    } else {
      throw new InValidInputException();
    }
    
    return canvasArea;
  }

  @Override
  public String[][] drawRectangle(int x1, int y1, int x2, int y2) throws InValidInputException {
    if (x1 > x2 && y1 > y2) {
      throw new InValidInputException();
    }
    drawRows(y1, x1, x2 + 1, "*\t");
    drawRows(y2, x1, x2 + 1, "*\t");
    drawColumnsForGivenRow(x1, y1, y2, "*\t");
    drawColumnsForGivenRow(x2, y1, y2, "*\t");
    return canvasArea;
  }

  @Override
  public String[][] fillColour(int x, int y, String colour) {
    for (int i = 1; i < canvasWidth - 1; i++) {
      for (int j = 1; j < canvasHeight - 1; j++) {
        if (!"*\t".equals(canvasArea[j][i])) {
          canvasArea[j][i] = colour;
        }
      }
    }
    return canvasArea;
  }
  
  private void drawRows(int row, int rowStart, int rowEnd, String symbol) throws InValidInputException {
    if(rowStart > rowEnd) throw new InValidInputException();
    for (int i = rowStart; i < rowEnd; i++) {
      canvasArea[row][i] = symbol;
    }
  }
  
  private void drawColumnsForGivenRow(int column, int columnStart, int columnEnd, String symbol) throws InValidInputException {
    if(columnStart > columnEnd) throw new InValidInputException();
    for (int i = columnStart; i < columnEnd; i++) {
      canvasArea[i][column] = symbol;
    }
  }
  
  private void prepare() {
    for (String[] canva : canvasArea) {
      Arrays.fill(canva, "\t");
    }
  }

  public String[][] getCanvasArea() {
    return this.canvasArea;
  }
  
}
