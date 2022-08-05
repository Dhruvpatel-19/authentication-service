package com.example.authenticationservice.jwt.controller;

import com.example.authenticationservice.jwt.JwtUtil;
import com.example.authenticationservice.jwt.model.JwtRequest;
import com.example.authenticationservice.jwt.model.JwtResponse;
import com.example.authenticationservice.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/token" , method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail() , jwtRequest.getPassword()));

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getEmail());

        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }


}
