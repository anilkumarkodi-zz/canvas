import exception.CanvasCreationException;
import exception.InValidExpressionException;
import exception.InValidInputException;


import static java.lang.Integer.parseInt;

public class DrawCanvas {
  private Canvas canvas = null;
  String[][] canvasArea = null;
  
  public void draw(String command) throws InValidExpressionException, CanvasCreationException, InValidInputException {
    final CommandValidator commandValidator = new CommandValidator();
    if (!commandValidator.isValidCommand(command) || !commandValidator.isValidExpression(command)) {
      throw new InValidExpressionException();
    }
    
    final String[] split = command.split(" ");
    final String commandType = split[0];
    
    if ("C".equals(commandType)) {
      canvas = new Canvas(parseInt(split[1]), parseInt(split[2]));
      canvasArea = canvas.create();
    }

    if ("L".equals(commandType)) {
      if (canvas == null) throw new CanvasCreationException("Please draw the canvas before draw line");
      canvasArea = canvas.drawLine(parseInt(split[1]), parseInt(split[2]), parseInt(split[3]), parseInt(split[4]));
    }
    
    if ("R".equals(commandType)) {
      if (canvas == null) throw new CanvasCreationException("Please draw the canvas before draw rectangle");
      canvasArea = canvas.drawRectangle(parseInt(split[1]), parseInt(split[2]), parseInt(split[3]), parseInt(split[4]));
    }
    if ("B".equals(commandType)) {
      if (canvas == null) throw new CanvasCreationException("Please draw the canvas before fill the colour");
      canvasArea = canvas.fillColour(parseInt(split[1]), parseInt(split[2]), split[3]+"\t");
    }
  }

  public void printCanvas(){
    for (String[] canvasList : canvasArea) {
      for (String canvas : canvasList) {
        System.out.print(canvas);
      }
      System.out.println();
    }
  }


}
