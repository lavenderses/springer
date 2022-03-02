package com.nakanoi.springer.access;

import javax.naming.NamingException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;

/** JNDI data source. */
@Configuration
public class JndiDataSource {

  @Bean(value = "jndiDataSource")
  public DataSource dataSource() throws NamingException {
    JndiTemplate jndiTemplate = new JndiTemplate();
    return jndiTemplate.lookup("java:comp/env/jdbc/springer", DataSource.class);
  }
}
