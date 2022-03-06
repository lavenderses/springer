package com.nakanoi.springer.advance.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Simple mvc configure. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.advance.account")
public class AdvanceConfig implements WebMvcConfigurer {

}
