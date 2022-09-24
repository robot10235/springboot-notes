package com.example.mpdemo.controller;

import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/query/all")
    public List queryAll() {
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }

    @PostMapping("/user/insert")
    public String save(User user) {
        int ret = userMapper.insert(user);
        if (ret > 0) {
            return "Insertion successful";
        } else {
            return "Insertion failure";
        }
    }

    @PostMapping("/user/delete")
    public String deleteById(int id) {
        int ret = userMapper.deleteById(id);
        if (ret > 0) {
            return "Deletion successful";
        } else {
            return "Deletion failure";
        }
    }

    @PostMapping("/user/update")
    public String updateUser(User user) {
        int ret = userMapper.updateById(user);
        if (ret > 0) {
            return "Update successful";
        } else {
            return "Update failure";
        }
    }

    @GetMapping("/user/byid")
    public User queryById(int id) {
        return userMapper.selectById(id);
    }
}
