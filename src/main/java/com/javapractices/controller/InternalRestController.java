package com.javapractices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InternalRestController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
