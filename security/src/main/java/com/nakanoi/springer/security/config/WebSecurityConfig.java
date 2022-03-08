package com.nakanoi.springer.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/** Simple web security config. */
@Configuration
@EnableWebSecurity
@ComponentScan("com.nakanoi.springer.security.listener")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers("/resources/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().loginPage("/login").defaultSuccessUrl("/menu").permitAll();
    http.authorizeRequests().anyRequest().authenticated();
    http.logout().logoutSuccessUrl("/login").permitAll();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
