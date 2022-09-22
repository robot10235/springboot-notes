package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.*;
import com.example.helloworld.entity.*;

@RestController
public class ParamsController {

    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public String getTest1() {
        return "Get request";
    }

    // http://localhost:8080/getTest2?nickname=zhangsan&phone=123
    @RequestMapping(value = "/getTest2", method = RequestMethod.GET)
    public String getTest2(String nickname, String phone) {
        System.out.println("nickname: " + nickname);
        System.out.println("phone: " + phone);
        return "Get request";
    }

    // http://localhost:8080/getTest3?nickname=zhangsan
    @RequestMapping(value = "/getTest3", method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname", required = false) String name) {
        System.out.println("nickname: " + name);
        return "Get request";
    }

    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public String postTest1() {
        return "Post request";
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(String nickname, String phone) {
        System.out.println("nickname: " + nickname);
        System.out.println("phone: " + phone);
        return "Post request";
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(User user) {
        System.out.println(user);
        return "Post request";
    }

    @RequestMapping(value = "/postTest4", method = RequestMethod.POST)
    // parse argument json data
    public String postTest4(@RequestBody User user) {
        System.out.println(user);
        return "Post request";
    }

    @GetMapping("/test/**")
    public String test() {
        return "wild card request";
    }
}
