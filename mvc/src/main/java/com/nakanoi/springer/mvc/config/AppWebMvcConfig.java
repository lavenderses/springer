package com.nakanoi.springer.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** DispatcherServlet config. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.mvc.app")
public class AppWebMvcConfig implements WebMvcConfigurer {

  @Bean
  OptionalValidatorFactoryBean validator() {
    return new OptionalValidatorFactoryBean();
  }

  @Override
  public Validator getValidator() {
    return validator();
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp();
  }
}
