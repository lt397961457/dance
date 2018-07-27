package com.dance.east.config.DynamicDatasouce;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.dance.east.mapper.dynamic", sqlSessionTemplateRef  = "sqlSessionTemplateDynamic")
public class DynamicDataSourceConfig {
    @Autowired
    @Qualifier("dynamicDataSource")
    DataSource dynamicDataSource;

    @Bean(name = "sqlSessionFactoryDynamic")
    public SqlSessionFactory sqlSessionFactoryDynamic() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        //指定mapper.xml的文件位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/dynamic/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManagerDynamic")
    public DataSourceTransactionManager transactionManagerDS2() {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

    @Bean(name = "sqlSessionTemplateDynamic")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryDynamic") SqlSessionFactory sqlSessionFactoryDynamic) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDynamic);
    }

//    @Autowired
//    private UserAModelMapper userAMapper;
//
//    @DS("dynamic-master")
//    public String ds1() {
//        return userAMapper.selectByPrimaryKey(1).getName();
//    }
//
//    @DS("dynamic-slvae")
//    public String ds2() {
//        return userAMapper.selectByPrimaryKey(1).getName();
//    }
}
