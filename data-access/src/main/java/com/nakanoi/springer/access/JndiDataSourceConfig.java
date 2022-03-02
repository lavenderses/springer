/*
package com.nakanoi.springer.access;


/** JNDI data source. * /
@Configuration
public class JndiDataSourceConfig {

  @Bean(name = "jndiDataSource")
  public DataSource dataSource() throws NamingException {
    JndiTemplate jndiTemplate = new JndiTemplate();
    return jndiTemplate.lookup("java:comp/env/jdbc/springer", DataSource.class);
  }
}
*/
