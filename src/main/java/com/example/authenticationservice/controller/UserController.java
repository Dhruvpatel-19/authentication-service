package com.example.authenticationservice.controller;

import com.example.authenticationservice.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/authenticationService/user")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @GetMapping(value = "/test")
    public String userTest(HttpServletRequest request){
        return "Only accessible to user";
    }
}
