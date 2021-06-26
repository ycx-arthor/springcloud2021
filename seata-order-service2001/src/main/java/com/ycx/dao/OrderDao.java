package com.ycx.dao;

import com.ycx.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void createOrder(Order order);

    void updateStatus(@Param("userId") Integer userId,@Param("status") Integer status);
}
