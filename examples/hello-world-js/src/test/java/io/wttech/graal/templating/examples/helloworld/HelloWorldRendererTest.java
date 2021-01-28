package io.wttech.graal.templating.examples.helloworld;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldRendererTest {

  @Test
  void testEmptyName() {
    HelloWorldRenderer renderer = new HelloWorldRenderer();
    String result = renderer.render("").block();
    assertThat(result).isEqualTo("Hello World!");
  }

  @Test
  void testProvidedName() {
    HelloWorldRenderer renderer = new HelloWorldRenderer();
    String result = renderer.render("Mitchell").block();
    assertThat(result).isEqualTo("Hello Mitchell!");
  }

}
