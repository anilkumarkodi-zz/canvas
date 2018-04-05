package exception;

public class CanvasCreationException extends CanvasException {
  private String message;

  public CanvasCreationException(String message) {
    this.message = message;
  }
}
