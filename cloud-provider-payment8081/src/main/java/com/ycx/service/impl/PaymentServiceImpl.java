package com.ycx.service.impl;

import com.ycx.dao.PaymentDao;
import com.ycx.entities.Payment;
import com.ycx.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment selectPaymentById(Long id) {
        return paymentDao.SelectPaymentById(id);
    }
}
