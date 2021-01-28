package io.wttech.graal.templating.javascript;

import io.wttech.graal.templating.TemplatingException;

public class JavascriptRendererException extends TemplatingException {

  public JavascriptRendererException() {
  }

  public JavascriptRendererException(String message) {
    super(message);
  }

  public JavascriptRendererException(String message, Throwable cause) {
    super(message, cause);
  }

  public JavascriptRendererException(Throwable cause) {
    super(cause);
  }

  public JavascriptRendererException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
