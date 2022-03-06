package com.nakanoi.springer.advance.config;

import com.nakanoi.springer.advance.commons.ClientInfoMdcPutFilter;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/** Simple initializer. */
public class AdvanceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  /*
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext applicationContext =
        new AnnotationConfigWebApplicationContext();
    applicationContext.register(AdvanceApplication.class);
    servletContext.addListener(new ContextLoaderListener(applicationContext));
    servletContext
        .addFilter("clientInfoMdcPutFilter", new ClientInfoMdcPutFilter())
        .addMappingForUrlPatterns(null, false, "/*");

    AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
    dispatcherContext.register(AdvanceConfig.class);

    ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("advance", new DispatcherServlet(dispatcherContext));
    dispatcher.setAsyncSupported(true);
    dispatcher.setMultipartConfig(new MultipartConfigElement("/tmp"));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
  */

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {AdvanceApplication.class, AsyncConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {AdvanceConfig.class};
  }

  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] {
      new ClientInfoMdcPutFilter(), new CharacterEncodingFilter(), new ResourceUrlEncodingFilter()
    };
  }

  @Override
  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
  }
}
