package com.nakanoi.springer.advance.config;

import com.nakanoi.springer.advance.cart.Cart;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

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

  @Bean
  public LocaleResolver localeResolver() {
    CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
    cookieLocaleResolver.setCookieName("locale");
    cookieLocaleResolver.setDefaultLocale(Locale.JAPANESE);
    return cookieLocaleResolver;
  }
}
