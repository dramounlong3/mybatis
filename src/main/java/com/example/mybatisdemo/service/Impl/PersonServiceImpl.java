package com.example.mybatisdemo.service.Impl;

import com.example.mybatisdemo.dao.PersonDao;
import com.example.mybatisdemo.model.PersonRecord;
import com.example.mybatisdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    @Override
    public List<PersonRecord> getPerson() {
        return personDao.getPerson();
    }
}
