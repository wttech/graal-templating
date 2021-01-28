package io.wttech.graal.templating.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * ScriptProvider wrapper responsible for caching the script.
 */
@RequiredArgsConstructor
public class CachedScriptProvider implements ScriptProvider {

  @NonNull
  private final ScriptProvider originalScriptProvider;
  private final Duration ttl;

  public static CachedScriptProvider of(ScriptProvider scriptProvider) {
    return new CachedScriptProvider(scriptProvider, null);
  }

  public static CachedScriptProvider of(ScriptProvider scriptProvider, Duration ttl) {
    return new CachedScriptProvider(scriptProvider, ttl);
  }

  @Override
  public Mono<String> getBundle() {
    return ttl != null
        ? originalScriptProvider.getBundle().cache(ttl)
        : originalScriptProvider.getBundle().cache();
  }

}
