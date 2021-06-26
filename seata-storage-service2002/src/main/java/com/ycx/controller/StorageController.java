package com.ycx.controller;

import com.ycx.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/update")
    void updateStorage(@RequestParam("productId") Integer productId,@RequestParam("count") Integer count){
        storageService.updateStorage(productId, count);
    }
}
