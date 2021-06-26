package com.ycx.service.impl;

import com.ycx.dao.AccountDao;
import com.ycx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void updateAccount(Integer userId, BigDecimal money) {
        accountDao.updateAccount(userId, money);
    }
}
