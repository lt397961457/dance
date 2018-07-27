package com.dance.east.config.DynamicDatasouce;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceBean {
    @Bean(name = "dataSourceDynamic1")
    @Qualifier("dataSourceDynamic1")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic1")
    public DataSource dataSourceDynamic1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceDynamic2")
    @Qualifier("dataSourceDynamic2")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic2")
    public DataSource dataSourceDynamic2() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource4Spring dynamicDataSource = new DynamicDataSource4Spring();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSourceDynamic1());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("dynamic-master", dataSourceDynamic1());
        dsMap.put("dynamic-slave", dataSourceDynamic2());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }
}
