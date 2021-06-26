package com.ycx.controller;

import com.ycx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/update")
    void updateAccount(@RequestParam("userId") Integer userId,@RequestParam("money") BigDecimal money){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountService.updateAccount(userId, money);
    }
}
