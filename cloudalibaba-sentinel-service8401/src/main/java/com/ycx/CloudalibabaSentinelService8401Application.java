package com.ycx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudalibabaSentinelService8401Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSentinelService8401Application.class, args);
    }

}
