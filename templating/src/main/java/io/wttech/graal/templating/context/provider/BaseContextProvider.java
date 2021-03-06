package io.wttech.graal.templating.context.provider;

import io.wttech.graal.templating.repository.ScriptProvider;
import lombok.AllArgsConstructor;
import org.graalvm.polyglot.Context;
import reactor.core.publisher.Mono;

@AllArgsConstructor(staticName = "of")
public class BaseContextProvider implements ContextProvider {

  private final ContextFactory contextFactory = ContextFactory.instance();
  private final ScriptProvider scriptProvider;

  public Mono<Context> getContext() {
    return scriptProvider.getBundle().map(contextFactory::createContext);
  }

}
