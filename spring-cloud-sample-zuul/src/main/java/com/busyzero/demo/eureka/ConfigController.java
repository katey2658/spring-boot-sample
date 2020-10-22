package com.busyzero.demo.eureka;

import com.busyzero.demo.stream.service.OrganizationService;
import com.busyzero.demo.stream.service.UserService;
import com.busyzero.demo.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ConfigController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/user/get", method = GET)
    public String get() {
        try{
            return userService.getName();
        } catch (Exception e) {
            return "问题";
        }

    }

    @RequestMapping(value = "/user/message", method = GET)
    public String sendMessage() {
        organizationService.sendMessage("data-message");
        return "ok";
    }
}
