package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.model.PersonRecord;
import com.example.mybatisdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sql")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<?> getPerson() {
        List<PersonRecord> personRecordList = personService.getPerson();
        return ResponseEntity.status(HttpStatus.OK).body(personRecordList);
    }
}
