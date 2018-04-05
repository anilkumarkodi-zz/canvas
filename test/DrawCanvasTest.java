import exception.CanvasCreationException;
import exception.InValidExpressionException;
import exception.InValidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Canvas.class})

public class DrawCanvasTest {

  @Test(expected = InValidExpressionException.class)
  public void shouldGetInValidExpressionExceptionWhenInValidInPutGiven() throws InValidExpressionException, CanvasCreationException, InValidInputException {
    final DrawCanvas drawCanvas = new DrawCanvas();
    drawCanvas.draw("A 20 20");
  }

  @Test(expected = CanvasCreationException.class)
  public void shouldGetCanvasCreationExceptionWhenDrawLineWithOutCanvas() throws InValidExpressionException, CanvasCreationException, InValidInputException {
    final DrawCanvas drawCanvas = new DrawCanvas();
    drawCanvas.draw("L 1 2 6 2");
  }

  @Test
  public void shouldCallCreateCanvasForGivenCommandIsCreateCanvas() throws InValidExpressionException, CanvasCreationException, Exception, InValidInputException {
    final Canvas canvasMock = mock(Canvas.class);
    final DrawCanvas drawCanvas = new DrawCanvas();
    drawCanvas.draw("C 10 10");
  }

}
