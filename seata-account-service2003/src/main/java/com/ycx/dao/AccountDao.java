package com.ycx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    void updateAccount(@Param("userId") Integer userId,@Param("money") BigDecimal money);
}
