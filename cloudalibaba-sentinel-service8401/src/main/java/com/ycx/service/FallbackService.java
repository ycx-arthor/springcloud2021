package com.ycx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-payment-provider",fallback = FallbackServiceImpl.class)
//@FeignClient(value = "nacos-payment-provider")
public interface FallbackService {
    @GetMapping("/payment/nacos/{id}")
     String getPayment(@PathVariable("id") Integer id);
}
