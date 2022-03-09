package com.nakanoi.springer.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Simple configuration for wep application. */
@Configuration
public class WebApplicationConfig implements WebMvcConfigurer {
  @Bean
  public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
    return new OpenEntityManagerInViewInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addWebRequestInterceptor(openEntityManagerInViewInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/**/*.html", "/**/*.css", "/**/*.js", "/**/*.png");
  }
}
