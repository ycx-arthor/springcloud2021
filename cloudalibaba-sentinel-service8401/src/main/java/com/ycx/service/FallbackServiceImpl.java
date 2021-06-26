package com.ycx.service;

import org.springframework.stereotype.Component;

@Component
//public class FallbackServiceImpl {
public class FallbackServiceImpl implements FallbackService{

    public String getPayment(Integer id) {
        return "------------openfeign兜底方法----------------";
    }
}
