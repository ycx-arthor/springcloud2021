package com.ycx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    void updateStorage(@Param("productId") Integer productId,@Param("count") Integer count);
}
