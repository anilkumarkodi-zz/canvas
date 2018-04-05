import org.junit.Test;
import validator.CommandValidator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandValidatorTest {
  
  @Test
  public void shouldGetFalseWhenItIsNotValidCommand() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validCommand = commandValidator.isValidCommand("A 1 2");
    assertFalse(validCommand);
  }
  
  @Test
  public void shouldGetTrueWhenItICreateCommand() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validCommand = commandValidator.isValidCommand("C 1 2");
    assertTrue(validCommand);
  }
  
  @Test
  public void shouldGetTrueWhenItIsLineCommand() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validCommand = commandValidator.isValidCommand("L 1 2");
    assertTrue(validCommand);
  }
  
  @Test
  public void shouldGetTrueWhenItIsRectangleCommand() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validCommand = commandValidator.isValidCommand("R 1 2");
    assertTrue(validCommand);
  }
  
  @Test
  public void shouldGetTrueWhenItIsQuitCommand() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validCommand = commandValidator.isValidCommand("Q");
    assertTrue(validCommand);
  }
  
  @Test
  public void shouldGetFalseWhenNotValidExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("A 1 3");
    assertFalse(validExpression);
  }
  
  @Test
  public void shouldGetTrueWhenValidCreationExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("C 20 4");
    assertTrue(validExpression);
  }
  
  @Test
  public void shouldGetFalseWhenInValidCreationExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("A -0 -4");
    assertFalse(validExpression);
  }
  
  @Test
  public void shouldGetTrueWhenValidLineLineExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("L 1 2 6 2");
    assertTrue(validExpression);
  }
  
  @Test
  public void shouldGetFalseWhenInValidLineLineExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("L -1 2 -6 2");
    assertFalse(validExpression);
  }
  
  @Test
  public void shouldGetFalseWhenInValidRectangleExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("R 14 1 18 3");
    assertTrue(validExpression);
  }
  
  @Test
  public void shouldGetTrueWhenValidRectangleExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("R -14 1 18 -3");
    assertFalse(validExpression);
  }


  @Test
  public void shouldGetFalseWhenInValidFillColourExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("B -10 3 o");
    assertFalse(validExpression);
  }

  @Test
  public void shouldGetTrueWhenValidFillColourExpressionGiven() {
    final CommandValidator commandValidator = new CommandValidator();
    final boolean validExpression = commandValidator.isValidExpression("B 10 3 o");
    assertTrue(validExpression);
  }
}
