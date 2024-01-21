package com.example.mybatisdemo.dao;

import com.example.mybatisdemo.model.PersonRecord;

import java.util.List;

public interface PersonDao {
    List<PersonRecord> getPerson();
}
