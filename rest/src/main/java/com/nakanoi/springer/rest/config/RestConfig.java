package com.nakanoi.springer.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Configuration for rest dispatcher servlet. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.rest")
public class RestConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/books/**")
        .allowedOrigins("https://example.com")
        .allowedMethods("GET", "POST", "DELETE", "PUT")
        .allowedHeaders("headers")
        .exposedHeaders("exposedHeaders");
  }
}
