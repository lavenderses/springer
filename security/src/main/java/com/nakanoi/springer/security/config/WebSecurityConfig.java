package com.nakanoi.springer.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/** Simple web security config. */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers("/resources/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().loginPage("/login").permitAll();
    http.authorizeRequests().anyRequest().authenticated();
  }
}
