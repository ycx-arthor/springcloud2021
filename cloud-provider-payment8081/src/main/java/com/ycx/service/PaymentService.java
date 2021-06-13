package com.ycx.service;

import com.ycx.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment selectPaymentById(Long id);
}
