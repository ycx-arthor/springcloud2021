package com.ycx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("seata-account-service")
public interface AccountService {
    @PostMapping("/account/update")
    void updateAccount(@RequestParam("userId") Integer userId,@RequestParam("money") BigDecimal money);
}
