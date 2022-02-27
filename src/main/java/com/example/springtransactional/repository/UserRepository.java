package com.example.springtransactional.repository;


import com.example.springtransactional.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}