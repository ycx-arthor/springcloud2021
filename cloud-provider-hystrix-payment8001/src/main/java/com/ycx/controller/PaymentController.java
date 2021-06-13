package com.ycx.controller;

import com.ycx.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String info_ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String info_timeout(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_timeout(id);
    }

    @GetMapping("/payment/hystrix/{id}")
    public String paymentFallback(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
