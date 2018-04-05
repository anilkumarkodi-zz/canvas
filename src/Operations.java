import Command.BaseCommand;
import Command.ColorCommand;
import exception.CanvasException;

public interface Operations {
  String[][] drawLine(BaseCommand baseCommand, Canvas canvas) throws CanvasException;
  String[][] drawRectangle(BaseCommand baseCommand, Canvas canvas) throws CanvasException;
  String[][] fillColour(ColorCommand colorCommand, Canvas canvas);
}
