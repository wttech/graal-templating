package io.wttech.graal.templating.spring.javascript;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.wttech.graal.templating.javascript.JavascriptRendererException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Optional;

@Configuration
public class JavascriptRendererAutoConfiguration {

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  JavascriptRendererSpringConfigurator provideJavascriptRendererDsl(Optional<ObjectMapper> objectMapper) {
    if (!objectMapper.isPresent()) {
      throw new JavascriptRendererException("ObjectMapper instance is not registered as a Spring bean.");
    }
    return JavascriptRendererSpringConfigurator.instance(objectMapper.get());
  }

}
