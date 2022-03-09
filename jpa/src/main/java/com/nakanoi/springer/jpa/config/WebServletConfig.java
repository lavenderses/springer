package com.nakanoi.springer.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Simple web servlet config. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.jpa.controller")
public class WebServletConfig implements WebMvcConfigurer {}
