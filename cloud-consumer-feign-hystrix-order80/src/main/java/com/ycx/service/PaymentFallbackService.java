package com.ycx.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements OrderService {
    @Override
    public String info_ok(Integer id) {
        return "-------PaymentFallbackService -- info_ok----  ┭┮﹏┭┮";
    }

    @Override
    public String info_timeout(Integer id) {
        return "-------PaymentFallbackService -- info_timeout----  ┭┮﹏┭┮";
    }
}
