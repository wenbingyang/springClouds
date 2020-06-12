package com.smd.employee.config;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MybatisBaseConfiguration {

    public static SqlSessionFactory buildSqlSessionFactory(
            DataSource source, String configLocationResource, String mybatisPlugin)
            throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(source);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        List<Resource> sourceList = new ArrayList<>();

        for (String resourceLocation : configLocationResource.split(",")) {
            sourceList.addAll(Arrays.asList(resolver.getResources(resourceLocation)));
        }
        sqlSessionFactoryBean.setMapperLocations(sourceList.toArray(new Resource[sourceList.size()]));
        if (mybatisPlugin != null) {
            sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisPlugin));
        }
        //map返回字段值为null返回时key缺失
        Configuration configuration = new Configuration();
        configuration.setCallSettersOnNulls(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        //configuration.getTypeHandlerRegistry().register("com.smd.employee.config.BlobTypeToStringHandler");
        //configuration.getTypeHandlerRegistry().register("com.smd.employee.config.ClobTypeToStringHandler");
        //configuration.getTypeHandlerRegistry().register("com.smd.employee.config.LongTypeToStringHandler");
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }
}
