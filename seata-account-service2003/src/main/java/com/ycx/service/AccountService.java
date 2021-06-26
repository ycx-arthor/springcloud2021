package com.ycx.service;

import java.math.BigDecimal;

public interface AccountService {
    void updateAccount(Integer userId, BigDecimal money);
}
