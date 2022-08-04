package com.example.authenticationservice.repository;


import com.example.authenticationservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String username);

    boolean existsByEmail(String email);
}
