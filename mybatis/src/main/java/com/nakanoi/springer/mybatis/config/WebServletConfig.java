package com.nakanoi.springer.mybatis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Simple configuration for web servlet. */
@Configuration
@EnableWebMvc
@ComponentScan({"com.nakanoi.springer.mybatis.controller", "com.nakanoi.springer.mybatis.service"})
public class WebServletConfig implements WebMvcConfigurer {}
