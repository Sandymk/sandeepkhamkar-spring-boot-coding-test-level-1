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

import com.codejam.demo.pojo.Schedule;
import com.codejam.demo.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getScheduleById(@PathVariable Integer id) throws Exception {
                return new ResponseEntity<>(scheduleService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> insertNewSchedule(@RequestBody Schedule schedule) throws Exception {
        return new ResponseEntity<>(scheduleService.saveSchedule(schedule), HttpStatus.CREATED);
    }
    

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateSchedule(@RequestBody Schedule schedule) throws Exception {
        return new ResponseEntity<>(scheduleService.updateSchedule(schedule), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteScheduleById(@PathVariable Integer id) throws Exception {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
