package com.shekhar.projector.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shekhar.kumar on 10/26/2018.
 */
@RestController
@RequestMapping("user-rest")
public class UserREST {


    @GetMapping(value = "/ping", produces = "application/json")
    public String ping(){
        return "OK";
    }

    @GetMapping(value = "/hello/{name}", produces = "application/json")
    public String hello(@PathVariable String name){
        return "Hello "+name+"!";
    }
}