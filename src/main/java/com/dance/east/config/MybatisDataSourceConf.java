package com.dance.east.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.dance.east.mapper.dance", sqlSessionTemplateRef  = "sqlSessionTemplateDS2")
public class MybatisDataSourceConf {
    @Autowired
    @Qualifier("dataSourceDS2")
    private DataSource dataSourceDS2;

    @Bean(name = "sqlSessionFactoryDS2")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceDS2") DataSource dataSourceDS2) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceDS2);
        //指定mapper.xml的文件位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManagerDS2")
    public DataSourceTransactionManager transactionManagerDS2() {
        return new DataSourceTransactionManager(dataSourceDS2);
    }

    @Bean(name = "sqlSessionTemplateDS2")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryDS2") SqlSessionFactory sqlSessionFactoryDS2) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDS2);
    }

}
