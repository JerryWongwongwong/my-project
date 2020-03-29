package com.jerry.myproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @RequestMapping("sayHello")
    public String sayHello() {

        return "hello!";
    }
}
