import java.util.Arrays;

import Command.BaseCommand;
import Command.ColorCommand;
import exception.CanvasCreationException;
import exception.CanvasException;
import exception.InValidInputException;

public class Canvas implements Operations {
  
  private final int canvasWidth;
  private final int canvasHeight;
  private String[][] canvasArea;
  private final String symbol = "-\t";
  private final int BORDER_LENGTH = 2;

  Canvas(int width, int height) throws InValidInputException {
    this.canvasWidth = width + BORDER_LENGTH;
    this.canvasHeight = height + BORDER_LENGTH;
    canvasArea = new String[canvasHeight][canvasWidth];
    createCanvas();
  }

  private void createCanvas() throws InValidInputException {
    prepare();
    final int canvasStart = 0;
    drawRows(canvasStart, canvasStart, canvasWidth, symbol, canvasArea);
    drawRows(canvasHeight - 1, canvasStart, canvasWidth, symbol, canvasArea);
    drawColumnsForGivenRow(canvasStart, canvasStart, canvasHeight - 1, symbol, canvasArea);
    drawColumnsForGivenRow(canvasWidth - 1, canvasStart, canvasHeight - 1, symbol, canvasArea);
  }

  @Override
  public String[][] drawLine(BaseCommand baseCommand, Canvas canvas) throws CanvasException {
    if(canvas == null) throw new CanvasCreationException("Create canvas to draw Line");

    if (baseCommand.y1 == baseCommand.y2) {
      drawRows(baseCommand.y1, baseCommand.x1, baseCommand.x2 + 1, "*\t", canvas.getCanvasArea());
    } else if (baseCommand.x1 == baseCommand.x2) {
      drawColumnsForGivenRow(baseCommand.x1, baseCommand.y1, baseCommand.y2 + 1, "*\t", canvas.getCanvasArea());
    } else {
      throw new InValidInputException();
    }
    return canvas.getCanvasArea();
  }

  @Override
  public String[][] drawRectangle(BaseCommand baseCommand, Canvas canvas) throws CanvasException {
    if(canvas == null) throw new CanvasCreationException("Create canvas to draw rectangle");
    if (baseCommand.x1 > baseCommand.x2 && baseCommand.y1 > baseCommand.y2) {
      throw new InValidInputException();
    }
    drawRows(baseCommand.y1, baseCommand.x1, baseCommand.x2 + 1, "*\t", canvas.getCanvasArea());
    drawRows(baseCommand.y2, baseCommand.x1, baseCommand.x2 + 1, "*\t", canvas.getCanvasArea());
    drawColumnsForGivenRow(baseCommand.x1, baseCommand.y1, baseCommand.y2, "*\t", canvas.getCanvasArea());
    drawColumnsForGivenRow(baseCommand.x2, baseCommand.y1, baseCommand.y2, "*\t", canvas.getCanvasArea());
    return canvas.getCanvasArea();
  }

  @Override
  public String[][] fillColour(ColorCommand colorCommand, Canvas canvas) {
    if (canvas == null) throw new CanvasCreationException("Please draw the canvas before fill the colour");
    for (int i = 1; i < canvas.getCanvasWidth() - 1; i++) {
      for (int j = 1; j < canvas.getCanvasHeight() - 1; j++) {
        if (!"*\t".equals(canvas.getCanvasArea()[j][i])) {
          canvas.canvasArea[j][i] = colorCommand.colour;
        }
      }
    }
    return canvas.getCanvasArea();
  }
  
  private void drawRows(int row, int rowStart, int rowEnd, String symbol, String[][] canvasArea) throws CanvasException {
    if(rowStart > rowEnd) throw new InValidInputException();
    for (int i = rowStart; i < rowEnd; i++) {
      canvasArea[row][i] = symbol;
    }
  }
  
  private void drawColumnsForGivenRow(int column, int columnStart, int columnEnd, String symbol, String[][] canvasArea) throws CanvasException {
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

  public int getCanvasWidth() {
    return canvasWidth;
  }

  public int getCanvasHeight() {
    return canvasHeight;
  }

  public String[][] getCanvasArea() {
    return this.canvasArea;
  }

}
