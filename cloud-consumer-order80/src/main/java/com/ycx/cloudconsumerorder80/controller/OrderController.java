package com.ycx.cloudconsumerorder80.controller;


import com.ycx.entities.CommonResult;
import com.ycx.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntities/{id}")
    public CommonResult<Payment> get2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()) return entity.getBody();
        else return new CommonResult(404, "查询失败", null);
    }

    @PostMapping("/consumer/paymentForEntities/create")
    public CommonResult<Payment> create2(Payment payment){
        CommonResult body = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();

         return body;

    }
}
