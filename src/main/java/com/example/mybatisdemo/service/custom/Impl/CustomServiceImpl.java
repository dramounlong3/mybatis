package com.example.mybatisdemo.service.custom.Impl;

import com.example.mybatisdemo.dao.custom.CustomDao;
import com.example.mybatisdemo.model.custom.CustomRecord;
import com.example.mybatisdemo.service.custom.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomDao customDao;

    @Override
    public List<CustomRecord> getCustom() {
        return customDao.getCustom();
    }

}
