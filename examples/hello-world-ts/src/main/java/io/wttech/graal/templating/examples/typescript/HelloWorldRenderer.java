package io.wttech.graal.templating.examples.typescript;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wttech.graal.templating.javascript.JavascriptRenderer;
import io.wttech.graal.templating.javascript.JavascriptRendererConfigurator;
import reactor.core.publisher.Mono;

public class HelloWorldRenderer {

  private final JavascriptRenderer renderer = JavascriptRendererConfigurator.instance()
      .objectMapper(new ObjectMapper())
      .classpathScript("/public/bundle.js")
      .buildProduction();

  public Mono<String> render(String name) {
    return renderer.render("hello", name);
  }

}
