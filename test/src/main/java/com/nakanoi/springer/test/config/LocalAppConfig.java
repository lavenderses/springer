package com.nakanoi.springer.test.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;

/** Simple local application config. */
@Configuration
@Profile("local")
@ComponentScan("com.nakanoi.springer.test.domain")
public class LocalAppConfig {
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("localMessages");
    return messageSource;
  }
}
