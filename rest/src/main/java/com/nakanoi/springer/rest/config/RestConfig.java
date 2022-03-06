package com.nakanoi.springer.rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
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

  @Bean
  ObjectMapper objectMapper() {
    return Jackson2ObjectMapperBuilder.json().indentOutput(true).build();
  }
}
