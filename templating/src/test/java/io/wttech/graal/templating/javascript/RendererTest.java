package io.wttech.graal.templating.javascript;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class RendererTest {

  private JavascriptRenderer renderer = JavascriptRendererConfigurator.instance()
      .objectMapper(new ObjectMapper())
      .classpathScript("/bundle.js")
      .buildDevelopment();

  @Test
  void render() {
    StepVerifier.create(renderer.render("hello", "World"))
        .assertNext(value -> Assertions.assertThat(value).isEqualTo("<div>World</div>"))
        .verifyComplete();
  }

}
