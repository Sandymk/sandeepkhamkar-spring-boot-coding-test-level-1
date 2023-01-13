package com.codejam.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codejam.demo.service.ToDoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class DemoController {
	
	@GetMapping(path = "/get-todos")
    ResponseEntity<?> getTodoData() throws Exception{
        String toDoUrl = "https://jsonplaceholder.typicode.com/todos/1";
        ToDoService toDoService = new ToDoService();
        return toDoService.getRequest(toDoUrl);
    }

    @GetMapping(path = "/unit-test")
    ResponseEntity<Integer> getUnitTestResult() throws Exception{
        return null;
    }

}
