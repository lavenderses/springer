package com.nakanoi.springer.advance.config;

import com.nakanoi.springer.advance.cart.Cart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

/** Simple app config. */
@Configuration
public class AdvanceApplication {

  @Bean
  @SessionScope
  public Cart cart() {
    return new Cart();
  }
}
