package com.example.mybatisdemo.dao.custom;

import com.example.mybatisdemo.model.custom.CustomRecord;

import java.util.List;

public interface CustomDao {
    List<CustomRecord> getCustom();
}
