package com.nakanoi.springer.security.config;

import javax.servlet.Filter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/** Simple application initializer. */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {
      WebApplicationConfig.class, DataSourceConfig.class, WebSecurityConfig.class
    };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {WebServletConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] {new DelegatingFilterProxy("springSecurityFilterChain")};
  }
}
