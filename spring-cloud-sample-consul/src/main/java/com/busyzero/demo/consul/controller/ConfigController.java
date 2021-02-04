package com.busyzero.demo.consul.controller;

import com.busyzero.demo.consul.config.MySqlComplexConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private MySqlComplexConfig mySqlComplexConfig;

    @RequestMapping("/hello")
    public String hello() {
        return "helle consul";
    }


    @GetMapping(value = "mysqluser")
    public String getMysqlUser(){
        System.out.println(mySqlComplexConfig.getHost());
        MySqlComplexConfig.UserInfo userInfo = mySqlComplexConfig.getUser();
        return userInfo.toString();
    }

}
