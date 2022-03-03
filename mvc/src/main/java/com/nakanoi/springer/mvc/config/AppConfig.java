package com.nakanoi.springer.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/** Application config. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.mvc")
public class AppConfig {}
