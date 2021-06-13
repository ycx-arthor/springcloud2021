package com.ycx.dao;

import com.ycx.entities.Payment;

public interface PaymentDao {
    int create(Payment payment);

    Payment SelectPaymentById(Long id);
}
