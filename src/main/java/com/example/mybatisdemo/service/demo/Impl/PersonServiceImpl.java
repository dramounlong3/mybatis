package com.example.mybatisdemo.service.demo.Impl;

import com.example.mybatisdemo.dao.demo.PersonDao;
import com.example.mybatisdemo.model.demo.PersonRecord;
import com.example.mybatisdemo.service.demo.PersonService;
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
