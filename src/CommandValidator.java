import java.util.regex.Pattern;

public class CommandValidator {

  private String creationCommand = "^[C]{1} [0-9]{1,2} [0-9]{1,2}$";
  private String drawLineCommand = "^[L]{1} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}$";
  private String drawRectangleCommand = "^[R]{1} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}$";
  private String fillColourCommand = "^[B]{1} [0-9]{1,2} [0-9]{1,2} [a-z]{1}$";

  public boolean isValidCommand(String command) {
    return command.startsWith("C")
            || command.startsWith("L")
            || command.startsWith("R")
            || command.startsWith("B")
            || command.startsWith("Q");
  }

  public boolean isValidExpression(String command){
    return Pattern.matches(creationCommand, command)
            || Pattern.matches(drawLineCommand, command)
            || Pattern.matches(drawRectangleCommand, command)
            || Pattern.matches(fillColourCommand, command);
  }
  
}
