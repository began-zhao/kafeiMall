package com.kafeimall.product.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author: zzg
 * @date: 8/22/22
 * @Description 自定义数据源
 */
//@Configuration
public class DataSourceProxyConfig {
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.type-handlers-package}")
    private String typeHandlersPackage;

    @PostConstruct
    public void afterPropertiesSet() {
        Properties pros = System.getProperties();
        pros.setProperty("druid.mysql.usePingMethod", "false");
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

//    @Primary
//    @Bean("dataSource")
//    public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSourceProxy);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources(mapperLocations));
//        bean.setTypeHandlersPackage(typeHandlersPackage);
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.setDefaultEnumTypeHandler(BasicEnumMybatisHandler.class);
//        bean.setConfiguration(configuration);
//        SqlSessionFactory factory;
//        try {
//            factory = bean.getObject();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return factory;
//    }
}
