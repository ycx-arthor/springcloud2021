package com.ycx.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ycx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "payment_global_fallback")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String info_ok(@PathVariable("id") Integer id) {

        return orderService.info_ok(id);
    }

    @GetMapping("consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
//    })
    @HystrixCommand
    public String info_timeout(@PathVariable("id") Integer id){
        return orderService.info_timeout(id);
    }

    public String paymentTimeOutFallback(@PathVariable("id") Integer id){
        return "我是80， 系统繁忙，请10秒钟后再试";
    }

    public String payment_global_fallback(){
        return "Global 222  对方系统繁忙或者已经宕机，请10秒钟再试！";
    }
}
