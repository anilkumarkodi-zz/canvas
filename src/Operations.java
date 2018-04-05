import exception.InValidInputException;

public interface Operations {
  String[][] create() throws InValidInputException;
  String[][] drawLine(int x1, int y1, int x2, int y2) throws InValidInputException;
  String[][] drawRectangle(int x1, int y1, int x2, int y2) throws InValidInputException;
  String[][] fillColour(int x, int y, String colour);
}
