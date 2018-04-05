package exception;

public class CanvasCreationException extends Throwable {
  private String message;

  public CanvasCreationException(String message) {
    this.message = message;
  }
}
