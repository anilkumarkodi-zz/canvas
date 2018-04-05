package validator;

import java.util.regex.Pattern;


import static Command.CommandType.*;

public class CommandValidator {

  private String creationCommand = "^[C]{1} [0-9]{1,2} [0-9]{1,2}$";
  private String drawLineCommand = "^[L]{1} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}$";
  private String drawRectangleCommand = "^[R]{1} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2} [0-9]{1,2}$";
  private String fillColourCommand = "^[B]{1} [0-9]{1,2} [0-9]{1,2} [a-z]{1}$";

  public boolean isValidCommand(String command) {
    return command.startsWith(C.name())
            || command.startsWith(L.name())
            || command.startsWith(R.name())
            || command.startsWith(B.name())
            || command.startsWith(Q.name());
  }

  public boolean isValidExpression(String command){
    return Pattern.matches(creationCommand, command)
            || Pattern.matches(drawLineCommand, command)
            || Pattern.matches(drawRectangleCommand, command)
            || Pattern.matches(fillColourCommand, command);
  }
  
}
