import java.util.Arrays;

import Command.BaseCommand;
import Command.ColorCommand;
import exception.CanvasCreationException;
import exception.CanvasException;
import exception.InValidInputException;

public class Board implements Operations {
  
  public Canvas draw(Canvas canvas) throws InValidInputException {
    prepare(canvas);
    final int canvasStart = 0;
    String symbol = "-\t";
    drawRows(canvasStart, canvasStart, canvas.getCanvasWidth(), symbol, canvas.getArea());
    drawRows(canvas.getCanvasHeight() - 1, canvasStart, canvas.getCanvasWidth(), symbol, canvas.getArea());
    drawColumnsForGivenRow(canvasStart, canvasStart, canvas.getCanvasHeight() - 1, symbol, canvas.getArea());
    drawColumnsForGivenRow(canvas.getCanvasWidth() - 1, canvasStart, canvas.getCanvasHeight() - 1, symbol, canvas.getArea());
    return canvas;
  }
  
  @Override
  public String[][] drawLine(BaseCommand baseCommand, Canvas canvas) throws CanvasException {
    if (canvas == null) throw new CanvasCreationException("Create board to draw Line");
    if (baseCommand.y1 == baseCommand.y2) {
      drawRows(baseCommand.y1, baseCommand.x1, baseCommand.x2 + 1, "*\t", canvas.getArea());
    } else if (baseCommand.x1 == baseCommand.x2) {
      drawColumnsForGivenRow(baseCommand.x1, baseCommand.y1, baseCommand.y2 + 1, "*\t", canvas.getArea());
    } else {
      throw new InValidInputException();
    }
    return canvas.getArea();
  }
  
  @Override
  public String[][] drawRectangle(BaseCommand baseCommand, Canvas canvas) throws CanvasException {
    if (canvas == null) throw new CanvasCreationException("Create board to draw rectangle");
    if (baseCommand.x1 > baseCommand.x2 && baseCommand.y1 > baseCommand.y2) {
      throw new InValidInputException();
    }
    drawRows(baseCommand.y1, baseCommand.x1, baseCommand.x2 + 1, "*\t", canvas.getArea());
    drawRows(baseCommand.y2, baseCommand.x1, baseCommand.x2 + 1, "*\t", canvas.getArea());
    drawColumnsForGivenRow(baseCommand.x1, baseCommand.y1, baseCommand.y2, "*\t", canvas.getArea());
    drawColumnsForGivenRow(baseCommand.x2, baseCommand.y1, baseCommand.y2, "*\t", canvas.getArea());
    return canvas.getArea();
  }
  
  @Override
  public String[][] fillColour(ColorCommand colorCommand, Canvas canvas) {
    if (canvas == null) throw new CanvasCreationException("Please draw the board before fill the colour");
    for (int i = 1; i < canvas.getCanvasWidth() - 1; i++) {
      for (int j = 1; j < canvas.getCanvasHeight() - 1; j++) {
        if (!"*\t".equals(canvas.getArea()[j][i])) {
          canvas.area[j][i] = colorCommand.colour;
        }
      }
    }
    return canvas.getArea();
  }
  
  private void drawRows(int row, int rowStart, int rowEnd, String symbol, String[][] canvasArea) throws CanvasException {
    if (rowStart > rowEnd) throw new InValidInputException();
    for (int i = rowStart; i < rowEnd; i++) {
      canvasArea[row][i] = symbol;
    }
  }
  
  private void drawColumnsForGivenRow(int column, int columnStart, int columnEnd, String symbol, String[][] canvasArea) throws CanvasException {
    if (columnStart > columnEnd) throw new InValidInputException();
    for (int i = columnStart; i < columnEnd; i++) {
      canvasArea[i][column] = symbol;
    }
  }
  
  private void prepare(Canvas canvas) {
    for (String[] canva : canvas.getArea()) {
      Arrays.fill(canva, "\t");
    }
  }
}
