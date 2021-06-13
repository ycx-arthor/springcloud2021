package com.ycx.controller;

import com.ycx.entities.CommonResult;
import com.ycx.entities.Payment;
import com.ycx.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        if(result>0) return new CommonResult(200, "加入数据成功, serverPort: "+ serverPort, result);
        else return new CommonResult(404, "加入数据失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.selectPaymentById(id);

        if(payment != null) return new CommonResult(200, "查询成功！, serverPort: "+ serverPort, payment);
        else return new CommonResult(404, "查询失败", null);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service:services){
            log.info("**********" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance instance: instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"
                    +instance.getPort()+"\t"+instance.getInstanceId()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }
}
