import Command.BaseCommand;
import Command.ColorCommand;
import exception.InValidInputException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {

  @Test
  public void shouldCreateCanvasForTheGivenHeightAndWidth() throws InValidInputException {
    int width = 3;
    int height = 3;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
    final String[][] actualCanvas = canvas.getArea();
    final String[][] expectedCanvas = new String[width+2][height+2];
    expectedCanvas[0][0] = "-\t";
    expectedCanvas[0][1] = "-\t";
    expectedCanvas[0][2] = "-\t";
    expectedCanvas[0][3] = "-\t";
    expectedCanvas[0][4] = "-\t";

    expectedCanvas[1][0] = "-\t";
    expectedCanvas[1][1] = "\t";
    expectedCanvas[1][2] = "\t";
    expectedCanvas[1][3] = "\t";
    expectedCanvas[1][4] = "-\t";
    
    expectedCanvas[4][0] = "-\t";
    expectedCanvas[4][1] = "-\t";
    expectedCanvas[4][2] = "-\t";
    expectedCanvas[4][3] = "-\t";
    expectedCanvas[4][4] = "-\t";

    assertEquals(expectedCanvas[0][0], actualCanvas[0][0]);
    assertEquals(expectedCanvas[0][1], actualCanvas[0][1]);
    assertEquals(expectedCanvas[0][2], actualCanvas[0][2]);
    assertEquals(expectedCanvas[0][3], actualCanvas[0][3]);
    assertEquals(expectedCanvas[0][4], actualCanvas[0][4]);

    assertEquals(expectedCanvas[1][0], actualCanvas[1][0]);
    assertEquals(expectedCanvas[1][1], actualCanvas[1][1]);
    assertEquals(expectedCanvas[1][2], actualCanvas[1][2]);
    assertEquals(expectedCanvas[1][3], actualCanvas[1][3]);
    assertEquals(expectedCanvas[1][4], actualCanvas[1][4]);


    assertEquals(expectedCanvas[4][0], actualCanvas[4][0]);
    assertEquals(expectedCanvas[4][1], actualCanvas[4][1]);
    assertEquals(expectedCanvas[4][2], actualCanvas[4][2]);
    assertEquals(expectedCanvas[4][3], actualCanvas[4][3]);
    assertEquals(expectedCanvas[4][4], actualCanvas[4][4]);
  }

  @Test(expected = InValidInputException.class)
  public void shouldThrowExceptionWhenDrawLineFromTheGivenXOrYAxisAreNotSameOnCanvasArea() throws InValidInputException {
    int width = 20;
    int height = 4;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
    board.drawLine(new BaseCommand(1, 2, 12, 20), canvas);
  }


  @Test(expected = InValidInputException.class)
  public void shouldThrowExceptionWhenAxisAreOutOfBounds() throws InValidInputException {
    int width = 5;
    int height = 5;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
    final BaseCommand lineBaseCommand = new BaseCommand(6, 2, 2, 20);
    board.drawLine(lineBaseCommand, canvas);
  }

  @Test
  public void shouldDrawLineFromTheGivenYAxisAreSameOnCanvasArea() throws InValidInputException {
    int width = 20;
    int height = 4;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
    board.drawLine(new BaseCommand(1, 2, 6, 2), canvas);
    final String[][] canvasArea = canvas.getArea();
    assertEquals(canvasArea[2][0], "-\t");
    assertEquals(canvasArea[2][1], "*\t");
    assertEquals(canvasArea[2][2], "*\t");
    assertEquals(canvasArea[2][3], "*\t");
    assertEquals(canvasArea[2][4], "*\t");
    assertEquals(canvasArea[2][5], "*\t");
    assertEquals(canvasArea[2][6], "*\t");
    assertEquals(canvasArea[2][7], "\t");
  }
  
  @Test
  public void shouldDrawLineFromTheGivenXAxisAreSameOnCanvasArea() throws InValidInputException {
    int width = 20;
    int height = 4;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
     BaseCommand baseCommand = new BaseCommand(6, 3, 6, 4);
    board.drawLine(baseCommand, canvas);
    final String[][] canvasArea = canvas.getArea();
    assertEquals(canvasArea[2][6], "\t");
    assertEquals(canvasArea[3][6], "*\t");
    assertEquals(canvasArea[4][6], "*\t");
    assertEquals(canvasArea[5][6], "-\t");
    
  }

  @Test(expected = InValidInputException.class)
  public void shouldGetInValidInputExceptionWhenInValidRectangleValues() throws InValidInputException {
    int width = 20;
    int height = 4;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
    board.drawRectangle(new BaseCommand(14, 3, 8, 1), canvas);
  }

  @Test
  public void shouldDrawRectangleFromTheGivenAxisAreOnCanvasArea() throws InValidInputException {
    int width = 20;
    int height = 4;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
    final String[][] canvasArea = board.drawRectangle(new BaseCommand(14, 1, 18, 3), canvas);
    
    assertEquals(canvasArea[1][14], "*\t");
    assertEquals(canvasArea[2][14], "*\t");
    assertEquals(canvasArea[3][14], "*\t");
    assertEquals(canvasArea[4][14], "\t");
    
    assertEquals(canvasArea[2][15], "\t");
    assertEquals(canvasArea[2][16], "\t");
    assertEquals(canvasArea[2][17], "\t");
    
    assertEquals(canvasArea[3][15], "*\t");
    assertEquals(canvasArea[3][16], "*\t");
    assertEquals(canvasArea[3][17], "*\t");
    
    assertEquals(canvasArea[1][18], "*\t");
    assertEquals(canvasArea[2][18], "*\t");
    assertEquals(canvasArea[3][18], "*\t");
  }
  
  @Test
  public void testShouldFillTheColour() throws InValidInputException {
    int width = 3;
    int height = 3;
    final Board board = new Board();
    final Canvas canvas = board.draw(new Canvas(width, height));
    board.drawRectangle(new BaseCommand(1, 1,1, 3), canvas);
    final String[][] canvasArea = board.fillColour(new ColorCommand(1, 3, "o\t"), canvas);
    assertEquals(canvasArea[1][1], "*\t");
    assertEquals(canvasArea[1][2], "o\t");
    assertEquals(canvasArea[1][3], "o\t");

    assertEquals(canvasArea[2][2], "o\t");
    assertEquals(canvasArea[2][3], "o\t");
  }
}
