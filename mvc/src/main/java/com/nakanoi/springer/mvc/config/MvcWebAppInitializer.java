package com.nakanoi.springer.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/** Code based configuration initializer. */
public class MvcWebAppInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // Application context to servlet context.
    AnnotationConfigWebApplicationContext applicationContext =
        new AnnotationConfigWebApplicationContext();
    applicationContext.register(AppConfig.class);
    servletContext.addListener(new ContextLoaderListener(applicationContext));

    // Dispatcher servlet to servlet context.
    AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
    dispatcherContext.register(AppWebMvcConfig.class);

    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("app", new DispatcherServlet(dispatcherContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
