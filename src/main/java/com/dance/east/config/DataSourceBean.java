package com.dance.east.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration

public class DataSourceBean {

    @Bean(name = "dataSourceDS2")
    @Qualifier("dataSourceDS2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource dataSourceDS2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceDS1")
    @Qualifier("dataSourceDS1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    @Primary
    public DataSource dataSourceDS1() {
        return DataSourceBuilder.create().build();
    }
}
