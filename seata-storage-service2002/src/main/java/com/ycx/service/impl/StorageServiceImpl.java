package com.ycx.service.impl;

import com.ycx.dao.StorageDao;
import com.ycx.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;

    @Override
    public void updateStorage(Integer productId, Integer count) {
        storageDao.updateStorage(productId, count);
    }
}
