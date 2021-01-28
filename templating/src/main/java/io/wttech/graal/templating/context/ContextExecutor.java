package io.wttech.graal.templating.context;

import org.graalvm.polyglot.Context;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Facade for interacting with the ContextPool.
 */
public interface ContextExecutor {

  <T> Mono<T> withContext(Function<Context, T> contextMapper);

}
