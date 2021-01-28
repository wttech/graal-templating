package io.wttech.graal.templating.repository;

import reactor.core.publisher.Mono;

/**
 * Defines how to retrieve the source file.
 */
public interface ScriptProvider {

  /**
   * Retrieves the source file.
   *
   * @return reactive pipeline with javascript source
   */
  Mono<String> getBundle();

}
