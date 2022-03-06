package com.nakanoi.springer.advance.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Simple mvc configure. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.advance")
public class AdvanceConfig implements WebMvcConfigurer {
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp();
  }
}
