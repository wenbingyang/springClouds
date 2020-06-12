package com.smd.employee.config;


import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = {"com.smd.employee.mapper"},
        sqlSessionFactoryRef = "smdSqlSessionFactory")
public class SmdSourceAutoConfiguration extends BasicConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource smdDataSource(Environment env) {
        AtomikosDataSourceBean datasource = new AtomikosDataSourceBean();
        Properties prop = build(env, "spring.datasource.");
        MysqlXADataSource mysqlXADataSource =new MysqlXADataSource();
        mysqlXADataSource.setUrl(prop.getProperty("url"));
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setUser(prop.getProperty("username"));
        mysqlXADataSource.setPassword(prop.getProperty("password"));
        mysqlXADataSource.setAllowMultiQueries(true);
        datasource.setXaDataSource(mysqlXADataSource);

        datasource.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        datasource.setUniqueResourceName("smdDataSource");
        datasource.setXaProperties(prop);
        datasource.setMaxPoolSize(35);
        return datasource;
    }

    @Bean
    @Primary
    public JdbcTemplate smdJdbcTemplate(@Qualifier("smdDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionFactory smdSqlSessionFactory(@Qualifier("smdDataSource") DataSource dataSource,
                                                 @Value("${spring.datasource.druid.smd.mapperLocations}") String configLocationResource)
            throws Exception {
        return MybatisBaseConfiguration
                .buildSqlSessionFactory(dataSource, configLocationResource, null);
    }


}
