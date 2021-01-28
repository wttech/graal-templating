package io.wttech.graal.templating.context.provider;

import org.graalvm.polyglot.Context;
import reactor.core.publisher.Mono;

public interface ContextProvider {

  Mono<Context> getContext();

}
