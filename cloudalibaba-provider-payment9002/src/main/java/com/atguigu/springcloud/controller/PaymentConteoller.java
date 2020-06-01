package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentConteoller {

    @Value("${server.port}")
    private String serverPost;


    @GetMapping(value = "/payment/nacos/{id}")
    public String fetPayment(@PathVariable("id") Integer id){
        return "nacos registry,serverPort:"+serverPost+"\t id"+id;
    }
}
