package com.scloud.discoveryeureka.controller;

import com.scloud.discoveryeureka.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController  {

    @RequestMapping("/getInfo")
    public String getDemoInfo(){
        return "this is a provider service";
    }

    @RequestMapping("/getString")
    public String getDemoInfo1(String userId){
        return userId+",this is a provider service";
    }

    @RequestMapping("/getUser")
    public User getUser(@RequestBody User user){
        return user;
    }

}
