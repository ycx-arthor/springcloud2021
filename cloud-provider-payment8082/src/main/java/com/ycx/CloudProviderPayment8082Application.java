package com.ycx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.ycx.dao")
@EnableDiscoveryClient
public class CloudProviderPayment8082Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8082Application.class, args);
    }

}
