package com.smd.employee.config;

import org.springframework.core.env.Environment;

import java.util.Properties;

public class BasicConfig {

    protected Properties build(Environment env, String prefix) {

        Properties prop = new Properties();
        prop.put("url", env.getProperty(prefix + "url"));
        prop.put("username", env.getProperty(prefix + "username"));
        prop.put("password", env.getProperty(prefix + "password"));
        prop.put("driverClassName", env.getProperty(prefix + "driverClassName", ""));

        return prop;
    }
}
