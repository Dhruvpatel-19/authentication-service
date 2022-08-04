package com.example.authenticationservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public String userTest(){
        return "Only accessible to user";
    }
}
