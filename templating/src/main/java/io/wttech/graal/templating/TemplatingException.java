package io.wttech.graal.templating;

public class TemplatingException extends RuntimeException {

  public TemplatingException() {
  }

  public TemplatingException(String message) {
    super(message);
  }

  public TemplatingException(String message, Throwable cause) {
    super(message, cause);
  }

  public TemplatingException(Throwable cause) {
    super(cause);
  }

  public TemplatingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
