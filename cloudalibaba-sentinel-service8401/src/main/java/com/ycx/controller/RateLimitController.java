package com.ycx.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ycx.entities.CommonResult;
import com.ycx.entities.Payment;
import com.ycx.handler.CustomBlockHandler;
import com.ycx.service.FallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名称限流测试ok",
                new Payment(2020L, "serial001"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handlerException",
            fallback = "handleException2")
    public CommonResult customerBlockHandler(){
        int i = 10/0;
        return new CommonResult(200, "按客户自定义，global handlerException",
                new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t服务不可用",null);
    }
    public CommonResult handleException2(){
        return new CommonResult(444, "\t服务不可用 o(╥﹏╥)o",null);
    }

    @Autowired
    private FallbackService fallbackService;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String testFallback(@PathVariable("id") Integer id){
        return fallbackService.getPayment(id);
    }
}
