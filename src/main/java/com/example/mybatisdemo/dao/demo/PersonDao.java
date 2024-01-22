package com.example.mybatisdemo.dao.demo;

import com.example.mybatisdemo.model.demo.PersonRecord;

import java.util.List;

public interface PersonDao {
    List<PersonRecord> getPerson();
}
