package com.nakanoi.springer.advance.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/** Simple initializer. */
public class AdvanceInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext applicationContext =
        new AnnotationConfigWebApplicationContext();
    applicationContext.register(AdvanceApplication.class);
    servletContext.addListener(new ContextLoaderListener(applicationContext));

    AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
    dispatcherContext.register(AdvanceConfig.class);

    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("advance", new DispatcherServlet(dispatcherContext));
    dispatcher.setMultipartConfig(new MultipartConfigElement("/tmp"));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
