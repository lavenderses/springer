package com.nakanoi.springer.advance.config;

import com.nakanoi.springer.advance.commons.CommonRequestDataMethodArgumentResolver;
import com.nakanoi.springer.advance.commons.SuccessLoggingInterceptor;
import com.nakanoi.springer.advance.file.CustomCallableProcessingInterceptor;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Simple mvc configure. */
@Configuration
@EnableWebMvc
@ComponentScan("com.nakanoi.springer.advance")
public class AdvanceConfig implements WebMvcConfigurer {
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp();
  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    configurer.setDefaultTimeout(5000);
    configurer.registerCallableInterceptors(new CustomCallableProcessingInterceptor());
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(new SuccessLoggingInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/resources/**");
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(new CommonRequestDataMethodArgumentResolver());
  }
}
