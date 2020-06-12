package com.scloud.discoveryeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DiscoveryEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryEurekaApplication.class, args);
    }

}
