import exception.CanvasCreationException;
import exception.InValidExpressionException;
import exception.InValidInputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consumer {
  
  public static void main(String[] args) throws IOException, InValidExpressionException, CanvasCreationException, InValidInputException {
    readCommand();
  }
  
  private static void readCommand() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final CanvasController canvasController = new CanvasController();
    
    while (true) {
      System.out.println("Enter Command to Continue:");
      final String command = reader.readLine();
      if ("Q".equals(command.split(" ")[0])) {
        break;
      }
      try {
        canvasController.draw(command);

      } catch (InValidExpressionException e) {
        e.printStackTrace();
      } catch (CanvasCreationException e) {
        e.printStackTrace();
      } catch (InValidInputException e) {
        e.printStackTrace();
      }
      canvasController.printCanvas();
    }
    
  }
}
