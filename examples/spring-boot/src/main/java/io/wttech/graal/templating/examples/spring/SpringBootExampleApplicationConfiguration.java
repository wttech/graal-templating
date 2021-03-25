package io.wttech.graal.templating.examples.spring;

import io.wttech.graal.templating.javascript.JavascriptRenderer;
import io.wttech.graal.templating.spring.javascript.JavascriptRendererSpringConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

@Configuration
public class SpringBootExampleApplicationConfiguration {

  private static final String SCRIPT_LOCATION = "localhost:8080/assets/bundle.js";
  private static final int RESPONSE_SIZE_LIMIT = 16 * 1024 * 1024;

  @Bean
  WebClient webClient() {
    return WebClient.builder()
        .exchangeStrategies(ExchangeStrategies.builder()
          .codecs(configurer -> configurer
              .defaultCodecs()
              .maxInMemorySize(RESPONSE_SIZE_LIMIT))
          .build())
        .build();
  }

  @Bean
  JavascriptRenderer javascriptRenderer(JavascriptRendererSpringConfigurator configurator, WebClient webClient) {
    return configurator.externalScript(builder -> builder.webClient(webClient).uri(URI.create(SCRIPT_LOCATION)).build())
        .buildDevelopment();
  }

  @Bean
  @Profile("production")
  JavascriptRenderer productionJavascriptRenderer(JavascriptRendererSpringConfigurator configurator, WebClient webClient) {
    return configurator.externalScript(builder -> builder.webClient(webClient).uri(URI.create(SCRIPT_LOCATION)).build())
        .buildProduction();
  }

  @Bean
  public RouterFunction<ServerResponse> staticContent() {
    return RouterFunctions.resources("/assets/**", new ClassPathResource("public/"));
  }

}
