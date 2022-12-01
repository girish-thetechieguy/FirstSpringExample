package com.techstarter.firstspringexample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @Value("${sample.test}")
//    private String configMessege;

    @GetMapping("/testAPI")
    public String displayMessege(){
        return "Welcome to Test controllers GET Method";
    }

//    @GetMapping("/get/messege")
//    public String displayMessegeFromConfig(){
//        return configMessege;
//    }

}
