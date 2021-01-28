package io.wttech.graal.templating.javascript;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wttech.graal.templating.context.ContextExecutor;
import io.wttech.graal.templating.context.ContextPool;
import io.wttech.graal.templating.context.provider.BaseContextProvider;
import io.wttech.graal.templating.context.provider.CachedContextProvider;
import io.wttech.graal.templating.context.provider.ContextProvider;
import io.wttech.graal.templating.repository.CachedScriptProvider;
import io.wttech.graal.templating.repository.ClasspathScriptProvider;
import io.wttech.graal.templating.repository.ScriptProvider;

import java.time.Duration;

/**
 * DSL for configuring JavascriptRenderer instances.
 */
public class JavascriptRendererConfigurator {

  private ObjectMapper objectMapper;
  private ScriptProvider scriptProvider;

  public static JavascriptRendererConfigurator instance() {
    return new JavascriptRendererConfigurator();
  }

  /**
   * Sets the classpath variant as the script provider.
   *
   * @param resourcePath path to the source file
   * @return builder
   */
  public JavascriptRendererConfigurator classpathScript(String resourcePath) {
    scriptProvider = ClasspathScriptProvider.of(resourcePath);
    return this;
  }

  /**
   * Sets the script provider used to retrieve the source.
   *
   * @param scriptProvider - provider
   * @return builder
   */
  public JavascriptRendererConfigurator scriptProvider(ScriptProvider scriptProvider) {
    this.scriptProvider = scriptProvider;
    return this;
  }

  /**
   * Sets the ObjectMapper used to convert to JSON objects passed as parameters.
   *
   * @param objectMapper Jackson mapper to be used within renderer
   * @return builder
   */
  public JavascriptRendererConfigurator objectMapper(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    return this;
  }

  /**
   * Builds Javascript renderer configured for production environment.
   * Script will be cached and won't be reloaded.
   * Context pool will contain as many instances as there are available processor cores.
   *
   * @return renderer
   */
  public JavascriptRenderer buildProduction() {
    validate();
    ScriptProvider cachedScriptProvider = CachedScriptProvider.of(scriptProvider);
    ContextProvider contextProvider = BaseContextProvider.of(cachedScriptProvider);
    ContextExecutor executor = ContextPool.production(contextProvider);
    return JavascriptRenderer.of(objectMapper, executor);
  }

  /**
   * Builds Javascript renderer configured for local development environment.
   * Script will be reloaded each time.
   * Context pool will contain only a single instance.
   *
   * @return renderer
   */
  public JavascriptRenderer buildDevelopment() {
    validate();
    ScriptProvider cachedScriptProvider = CachedScriptProvider.of(scriptProvider, Duration.ofMillis(100));
    ContextProvider contextProvider = CachedContextProvider.of(cachedScriptProvider);
    ContextExecutor executor = ContextPool.development(contextProvider);
    return JavascriptRenderer.of(objectMapper, executor);
  }

  private void validate() {
    if (objectMapper == null) {
      throw new IllegalStateException(
          "JSON mapper must be configured. Use objectMapper() method.");
    }
    if (scriptProvider == null) {
      throw new IllegalStateException(
          "Bundle repository must be configured. Use classpath/scriptProvider methods.");
    }
  }

}
