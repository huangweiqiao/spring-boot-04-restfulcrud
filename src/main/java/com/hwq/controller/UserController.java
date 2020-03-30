package com.hwq.controller;

import com.hwq.jpa.entity.User;
import com.hwq.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/userJpa/{id}")
    public User getUser(@PathVariable("id") Integer id){
       return userRepository.findOne(id);
    }

    @GetMapping("/userJpa")
    public User insertUser(User user){
       User save =  userRepository.save(user);
        return save;
    }
}
