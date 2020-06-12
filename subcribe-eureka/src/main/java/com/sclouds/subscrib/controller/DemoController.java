package com.sclouds.subscrib.controller;


import com.sclouds.subscrib.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test1")
    public String getEurekaServiceInfo(){
        /**
         * exchange(url,type,paras,resutType)
         * url：请求地址
         * type：请求类型 get,post
         * paras：参数
         * resutType：返回值类型
         */
        String url="http://localhost:8083/getInfo";
        HttpMethod type=HttpMethod.GET;
        RequestEntity<String> paras=null;
        ResponseEntity<String> responseEntity=restTemplate.exchange(url,type,paras,String.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/test2")
    public String getString1(){
        //getForObject 调用无参方法，返回结果为String的方法
        String url="http://localhost:8083/getInfo";
        String res=restTemplate.getForObject(url,String.class);
        return res;
    }

    @RequestMapping("/test3")
    public String getString2(){
        //getForObject 调用有参方法，路径添加参数。返回结果为String的方法
        String url="http://localhost:8083/getString?userId=sn001";
        String res=restTemplate.getForObject(url,String.class);
        return res;
    }

    @RequestMapping("/test4")
    public User getUser(){
        //参数为实体类对象，返回结果为实体类对象
        User user=new User();
        user.setUserId("1");
        user.setUserName("zsc");
        user.setPassword("123");
        String url="http://localhost:8083/getUser";
        //User u=restTemplate.getForObject(url,User.class,user);
        User u =restTemplate.postForObject(url,user,User.class);
        logger.info("getUser111111：" + url+"  getUser2222："  + u);
        return u;
    }



}
