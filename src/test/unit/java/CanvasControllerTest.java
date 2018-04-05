import exception.CanvasCreationException;
import exception.InValidExpressionException;
import exception.InValidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CanvasControllerTest {

  @Test(expected = InValidExpressionException.class)
  public void shouldGetInValidExpressionExceptionWhenInValidInPutGiven() throws InValidExpressionException, CanvasCreationException, InValidInputException {
    final CanvasController canvasController = new CanvasController();
    canvasController.draw("A 20 20");
  }

  @Test(expected = CanvasCreationException.class)
  public void shouldGetCanvasCreationExceptionWhenDrawLineWithOutCanvas() throws InValidExpressionException, CanvasCreationException, InValidInputException {
    final CanvasController canvasController = new CanvasController();
    canvasController.draw("L 1 2 6 2");
  }

}
