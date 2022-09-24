package com.example.helloworld.controller;

import com.example.helloworld.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @ApiOperation("get user info")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) { // @PathVariable to get id in path
        return "get user by id";
    }

    @PostMapping("/user")
    public String save(User user) {
        return "add user";
    }

    @PutMapping("/user")
    public String update(User user) {
        return "update user";
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id) {
        return "delete user by id";
    }
}
