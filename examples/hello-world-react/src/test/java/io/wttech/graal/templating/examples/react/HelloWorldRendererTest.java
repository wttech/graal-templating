package io.wttech.graal.templating.examples.react;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldRendererTest {

  @Test
  void testEmptyName() {
    HelloWorldRenderer renderer = new HelloWorldRenderer();
    String result = renderer.render("").block();
    assertThat(result).isEqualTo("<div data-reactroot=\"\"><div>Hello <!-- -->World<!-- -->!</div></div>");
  }

  @Test
  void testProvidedName() {
    HelloWorldRenderer renderer = new HelloWorldRenderer();
    String result = renderer.render("Mitchell").block();
    assertThat(result).isEqualTo("<div data-reactroot=\"\"><div>Hello <!-- -->Mitchell<!-- -->!</div></div>");
  }

}
