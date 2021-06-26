package com.ycx.service.impl;

import com.ycx.dao.OrderDao;
import com.ycx.domain.Order;
import com.ycx.service.AccountService;
import com.ycx.service.OrderService;
import com.ycx.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        orderDao.createOrder(order);
        storageService.updateStorage(order.getProductId(),order.getCount());
        accountService.updateAccount(order.getUserId(),order.getMoney());
        orderDao.updateStatus(order.getUserId(),0);
    }
}
