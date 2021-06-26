package com.ycx.cloudconfigclient3366.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyConfigClientController {
    @Value("${config.info}")
    private String config_info;

    @Value("${server.port}")
    private  String serverPort;

    @GetMapping("/config_info")
    public String info(){
        return "serverPort:  "+serverPort + "\tconfig_info:  " + config_info;
    }
}
