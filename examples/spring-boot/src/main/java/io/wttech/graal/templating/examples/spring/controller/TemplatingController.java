package io.wttech.graal.templating.examples.spring.controller;

import io.wttech.graal.templating.javascript.JavascriptRenderer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
public class TemplatingController {

  private final JavascriptRenderer renderer;

  public TemplatingController(JavascriptRenderer renderer) {
    this.renderer = renderer;
  }

  @GetMapping(value = {"/", "/{name}"}, produces = MediaType.TEXT_HTML_VALUE)
  public Mono<String> home(@PathVariable Optional<String> name) {
    return renderer.render("hello", String.format("{\"name\":\"%s\"}", name.orElse("")));
  }

}
