package com.nakanoi.springer.test.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;

/** Simple application config. */
@Configuration
@Profile("default")
@ComponentScan("com.nakanoi.springer.test.domain")
public class AppConfig {
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("messages");
    return messageSource;
  }
}
