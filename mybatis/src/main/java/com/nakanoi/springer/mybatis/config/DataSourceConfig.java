package com.nakanoi.springer.mybatis.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {
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
}
