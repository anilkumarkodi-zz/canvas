import Command.BaseCommand;
import Command.ColorCommand;
import exception.CanvasCreationException;
import exception.InValidExpressionException;
import exception.InValidInputException;
import validator.CommandValidator;

import static java.lang.Integer.parseInt;

public class CanvasController {
  private Canvas canvas = null;
  
  public void draw(String command) throws InValidExpressionException, CanvasCreationException, InValidInputException {
    final CommandValidator commandValidator = new CommandValidator();
    if (!commandValidator.isValidCommand(command) || !commandValidator.isValidExpression(command)) {
      throw new InValidExpressionException();
    }
    
    final String[] split = command.split(" ");
    final String userCommand = split[0];
    
    if (Command.CommandType.C.name().equals(userCommand)) {
      canvas = new Canvas(parseInt(split[1]), parseInt(split[2]));
    }

    if (Command.CommandType.L.name().equals(userCommand)) {
      if(canvas == null) throw new CanvasCreationException("Create canvas to draw Line");
      final BaseCommand lineBaseCommand = new BaseCommand(parseInt(split[1]), parseInt(split[2]), parseInt(split[3]), parseInt(split[4]));
      canvas.drawLine(lineBaseCommand, canvas);
    }
    
    if (Command.CommandType.R.name().equals(userCommand)) {
      if(canvas == null) throw new CanvasCreationException("Create canvas to draw rectangle");
      final BaseCommand rectangleBaseCommand = new BaseCommand(parseInt(split[1]), parseInt(split[2]), parseInt(split[3]), parseInt(split[4]));
      canvas.drawRectangle(rectangleBaseCommand, canvas);
    }
    if (Command.CommandType.B.name().equals(userCommand)) {
      if(canvas == null) throw new CanvasCreationException("Create canvas to fill colors");
      final ColorCommand colorCommand = new ColorCommand(parseInt(split[1]), parseInt(split[2]), split[3] + "\t");
      canvas.fillColour(colorCommand, canvas);
    }
    printCanvas();
  }
  
  private void printCanvas() {
    for (String[] canvasList : canvas.getCanvasArea()) {
      for (String canvas : canvasList) {
        System.out.print(canvas);
      }
      System.out.println();
    }
  }
}
