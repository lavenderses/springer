package com.nakanoi.springer.advance.config;

import com.nakanoi.springer.advance.cart.Cart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/** Simple app config. */
@Configuration
public class AdvanceApplication {
  @Bean
  public MultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }

  @Bean
  @SessionScope
  public Cart cart() {
    return new Cart();
  }
}
