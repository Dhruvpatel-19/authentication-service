package com.example.authenticationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authenticationService/owner")
public class OwnerController {

    @GetMapping(value = "/test")
    public String ownerTest(){
        return "Only accessible to owner";
    }
}
