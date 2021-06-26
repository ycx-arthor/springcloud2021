package com.ycx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageService {
    @PostMapping("/storage/update")
    void updateStorage(@RequestParam("productId") Integer productId,@RequestParam("count") Integer count);
}
