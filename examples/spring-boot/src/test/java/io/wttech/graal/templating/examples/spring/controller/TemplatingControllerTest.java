package io.wttech.graal.templating.examples.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableAutoConfiguration
@AutoConfigureWebTestClient
class TemplatingControllerTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  void testProvidedName() {
    webClient.get()
        .uri("/Mitchell")
        .accept(MediaType.TEXT_HTML)
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class).isEqualTo("<div data-reactroot=\"\"><div>Hello <!-- -->Mitchell<!-- -->!</div></div>");
  }

  @Test
  void testEmptyNameVariable() {
    webClient.get()
        .uri("/")
        .accept(MediaType.TEXT_HTML)
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class).isEqualTo("<div data-reactroot=\"\"><div>Hello <!-- -->World<!-- -->!</div></div>");
  }

}
