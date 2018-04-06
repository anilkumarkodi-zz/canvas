import Command.BaseCommand;
import Command.ColorCommand;
import exception.CanvasCreationException;
import exception.CanvasException;
import exception.InValidExpressionException;
import validator.CommandValidator;


import static java.lang.Integer.parseInt;

public class CanvasController {
  private Board board = null;
  private Canvas canvas = null;
  
  public void draw(String command) throws CanvasException {

    final CommandValidator commandValidator = new CommandValidator();
    if (!commandValidator.isValidCommand(command) || !commandValidator.isValidExpression(command)) {
      throw new InValidExpressionException();
    }

    final String[] split = command.split(" ");
    final String userCommand = split[0];

    if (Command.CommandType.C.name().equals(userCommand)) {
      canvas = new Canvas(parseInt(split[1]), parseInt(split[2]));
      board = new Board();
      board.draw(canvas);
    }
    
    if (Command.CommandType.L.name().equals(userCommand)) {
      if (board == null) throw new CanvasCreationException("Create board to draw Line");
      final BaseCommand lineBaseCommand = new BaseCommand(parseInt(split[1]), parseInt(split[2]), parseInt(split[3]), parseInt(split[4]));
      board.drawLine(lineBaseCommand, canvas);
    }
    
    if (Command.CommandType.R.name().equals(userCommand)) {
      if (board == null) throw new CanvasCreationException("Create board to draw rectangle");
      final BaseCommand rectangleBaseCommand = new BaseCommand(parseInt(split[1]), parseInt(split[2]), parseInt(split[3]), parseInt(split[4]));
      board.drawRectangle(rectangleBaseCommand, canvas);
    }
    
    if (Command.CommandType.B.name().equals(userCommand)) {
      if (board == null) throw new CanvasCreationException("Create board to fill colors");
      final ColorCommand colorCommand = new ColorCommand(parseInt(split[1]), parseInt(split[2]), split[3] + "\t");
      board.fillColour(colorCommand, canvas);
    }
    printCanvas(canvas);
  }
  
  private void printCanvas(Canvas canvas) {
    if (canvas == null) throw new CanvasCreationException("Canvas creation failed");
    for (String[] canvasRow : canvas.getArea()) {
      for (String canvasColumn : canvasRow) {
        System.out.print(canvasColumn);
      }
      System.out.println();
    }
  }
}
