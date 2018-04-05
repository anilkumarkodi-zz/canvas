import exception.CanvasException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandReader {
  
  public static void main(String[] args) throws IOException, CanvasException {
    readCommand();
  }
  
  private static void readCommand() throws IOException, CanvasException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final CanvasController canvasController = new CanvasController();

    while (true) {
      System.out.println("Enter command to continue:");
      final String command = reader.readLine();
      if ("Q".equals(command.split(" ")[0])) {
        System.out.println("Quiting the program...");
        break;
      }
      canvasController.draw(command);
    }
  }
}
