package com.dance.east.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * 由于多数据源的配置，导致很多默认的bean失效，所以只要配置了多数据源，原来的单数据源不能像开始那样简单的配置
 * 也要单独配置，也就是最后成了3个数据源
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef="erpEntityManagerFactory",
        transactionManagerRef="erpTransactionManager",
        basePackages = {"com.dance.east.mapper.jpa"}//设置dao（repo）所在位置
)
public class JpaDataSourceConf {

    @Autowired
    @Qualifier("dataSourceDS1")
    private DataSource dataSourceDS1;

    @Bean(name = "entityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return erpEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "erpEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean erpEntityManagerFactory (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSourceDS1)
//                .properties(getVendorProperties(dataSourceDS1))
                .packages("com.dance.east.entity")
                .persistenceUnit("erpPersistenceUnit")
                .build();
    }

//    @Autowired
//    private JpaProperties jpaProperties;
//
//    private Map getVendorProperties(DataSource dataSource) {
//        return jpaProperties.getHibernateProperties(dataSourceDS1);
//    }

    @Bean(name = "erpTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(erpEntityManagerFactory(builder).getObject());
    }

}
