package com.codejam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codejam.demo.pojo.PersonalInformation;
import com.codejam.demo.service.PersonalInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo/personal-info")
public class IdolPersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getIdolPersonalInfoById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(personalInfoService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> insertNewPersonalInfo(@RequestBody PersonalInformation personalInfo) throws Exception {
        return new ResponseEntity<>(personalInfoService.savePersonalInfo(personalInfo), HttpStatus.CREATED);
    }
    

    @PostMapping(path = "/update")
    public ResponseEntity<?> updatePersonalInfo(@RequestBody PersonalInformation personalInfo) throws Exception {
        return new ResponseEntity<>(personalInfoService.updatePersonalInfo(personalInfo), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deletePersonalInfoById(@PathVariable Integer id) throws Exception {
    	personalInfoService.deletePersonalInfo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(path = "/getrandominfo")
    public ResponseEntity<?> randomPersonalInfo() throws Exception {
        return new ResponseEntity<>(personalInfoService.getRandomPersonalInfo(), HttpStatus.OK);
    }

}
