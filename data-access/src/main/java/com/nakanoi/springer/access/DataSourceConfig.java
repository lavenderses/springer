package com.nakanoi.springer.access;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/** Data source config. */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

  /**
   * Simple datasource creation.
   *
   * @param driverClassName Database driver class name.
   * @param url Database URL.
   * @param username Database username.
   * @param password Database password.
   * @param maxTotal Database max total.
   * @param maxIdle Database max idling.
   * @param minIdle Database min idling.
   * @param maxWaitMills Database max waiting time.
   * @return Datasource.
   */
  @Bean(name = "poolingDataSource", destroyMethod = "close")
  @Primary
  public DataSource dataSource(
      @Value("${database.driverClassName}") String driverClassName,
      @Value("${database.url}") String url,
      @Value("${database.username}") String username,
      @Value("${database.password}") String password,
      @Value("${cp.maxTotal}") int maxTotal,
      @Value("${cp.maxIdle}") int maxIdle,
      @Value("${cp.minIdle}") int minIdle,
      @Value("${cp.maxWaitMills}") long maxWaitMills) {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setMaxTotal(maxTotal);
    dataSource.setMaxIdle(maxIdle);
    dataSource.setMinIdle(minIdle);
    dataSource.setMaxWaitMillis(maxWaitMills);
    return dataSource;
  }

  /*
  @Bean(name = "jndiDataSource")
  public DataSource dataSource() throws NamingException {
    JndiTemplate jndiTemplate = new JndiTemplate();
    return jndiTemplate.lookup("java:comp/env/jdbc/springer", DataSource.class);
  }
   */
}
