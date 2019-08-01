package com.busyzero.demo.v10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefreshController implements ApplicationContextAware {

    private AbstractApplicationContext applicationContext;

    @Value("${server.name}")
    private String serverName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (AbstractApplicationContext) applicationContext;
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public String refresh(){
        applicationContext.refresh();
        return "ok";
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String getName(){
        return serverName;
    }
}
