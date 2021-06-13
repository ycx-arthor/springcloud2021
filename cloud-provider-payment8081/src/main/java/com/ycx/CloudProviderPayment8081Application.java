package com.ycx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@MapperScan(basePackages = "com.ycx.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudProviderPayment8081Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8081Application.class, args);
    }

}
