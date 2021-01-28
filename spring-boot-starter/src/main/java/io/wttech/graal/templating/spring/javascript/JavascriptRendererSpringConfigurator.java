package io.wttech.graal.templating.spring.javascript;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wttech.graal.templating.javascript.JavascriptRenderer;
import io.wttech.graal.templating.javascript.JavascriptRendererConfigurator;
import io.wttech.graal.templating.repository.ScriptProvider;
import io.wttech.graal.templating.spring.repository.ExternalScriptProvider;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class JavascriptRendererSpringConfigurator {

  private final JavascriptRendererConfigurator configurator;

  public static JavascriptRendererSpringConfigurator instance(ObjectMapper mapper) {
    JavascriptRendererConfigurator original = JavascriptRendererConfigurator.instance();
    original.objectMapper(mapper);
    return new JavascriptRendererSpringConfigurator(original);
  }

  public JavascriptRendererSpringConfigurator classpathScript(String resourcePath) {
    configurator.classpathScript(resourcePath);
    return this;
  }

  public JavascriptRendererSpringConfigurator externalScript(Consumer<ExternalScriptProvider.Builder> repositoryConfigurer) {
    ExternalScriptProvider.Builder builder = ExternalScriptProvider.builder();
    repositoryConfigurer.accept(builder);
    configurator.scriptProvider(builder.build());
    return this;
  }

  public JavascriptRendererSpringConfigurator scriptProvider(ScriptProvider scriptProvider) {
    configurator.scriptProvider(scriptProvider);
    return this;
  }

  public JavascriptRenderer buildProduction() {
    return configurator.buildProduction();
  }

  public JavascriptRenderer buildDevelopment() {
    return configurator.buildDevelopment();
  }

}
