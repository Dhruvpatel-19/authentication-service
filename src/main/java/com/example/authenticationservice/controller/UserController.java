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
        String requestTokenHeader = request.getHeader("Authorization");
        String email = null;
        String jwtToken =jwtToken = requestTokenHeader.substring(7);
        email = jwtUtil.extractUsername(jwtToken);
        System.out.println("User email is : "+email);
        return "Only accessible to user";
    }
}
