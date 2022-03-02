package com.nakanoi.springer.access;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** Data source config import. */
@Configuration
@Import({PoolingDataSourceConfig.class, JndiDataSource.class})
public class DataSourceConfig {}
