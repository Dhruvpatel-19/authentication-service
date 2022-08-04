package com.example.authenticationservice.service;

import com.example.authenticationservice.entity.Owner;
import com.example.authenticationservice.entity.User;
import com.example.authenticationservice.repository.OwnerRepository;
import com.example.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private OwnerRepository ownerRepository;


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Owner owner = ownerRepository.findByEmail(username);

        if(owner == null){

            User user = userRepository.findByEmail(username);
            if(user == null){
                throw new UsernameNotFoundException("User not found");
            }
            return new CustomUserDetails(user);
        }
        else{
            return new CustomOwnerDetails(owner);
        }

    }
}
