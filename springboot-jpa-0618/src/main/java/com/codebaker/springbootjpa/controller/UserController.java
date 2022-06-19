package com.codebaker.springbootjpa.controller;


import com.codebaker.springbootjpa.entity.User;
import com.codebaker.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User ayUser = new User();
        ayUser.setId(id);
        Example<User> example = Example.of(ayUser);
        Optional<User> one = userRepository.findOne(example);

        if (one.isPresent()) {
            ayUser = one.get();
            return ayUser;
        } else {
            return null;
        }
    }


    @GetMapping("/user")
    public User insertUser(User user) {
        User save = userRepository.save(user);
        return save;
    }
}
