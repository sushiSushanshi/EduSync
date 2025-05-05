package com.EduSync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/message")
    public String getMessge(){
        return "You are seeing a secured message.....";
    }
}
