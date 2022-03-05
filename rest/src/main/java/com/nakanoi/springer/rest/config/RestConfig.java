package com.nakanoi.springer.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/** Configuration for rest dispatcher servlet. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.rest")
public class RestConfig {}
