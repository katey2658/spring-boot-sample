package com.busyzero.demo.stream;

import com.busyzero.demo.stream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ConfigController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/get", method = GET)
    public String get() {
        try{
            return userService.getName();
        } catch (Exception e) {
            return "问题";
        }

    }
}
