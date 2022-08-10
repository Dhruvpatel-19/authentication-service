package com.example.authenticationservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authenticationService/owner")
public class OwnerController {

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public String ownerTest(){
        return "Only accessible to owner";
    }
}
