package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.model.custom.CustomRecord;
import com.example.mybatisdemo.service.custom.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;

    @GetMapping("/list")
    public ResponseEntity<?> getCustom() {
        List<CustomRecord> customRecordList = customService.getCustom();
        return ResponseEntity.status(HttpStatus.OK).body(customRecordList);
    }
}
