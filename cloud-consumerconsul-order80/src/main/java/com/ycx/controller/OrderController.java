package com.ycx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @RequestMapping("/consumer/payment/consul")
    public String consumerConsul(){
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);

        return  forObject;
    }
}
