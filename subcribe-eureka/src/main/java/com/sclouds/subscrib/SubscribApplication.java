package com.sclouds.subscrib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SubscribApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscribApplication.class, args);
    }

    //向spring里注入一个RestTemplate对象
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
