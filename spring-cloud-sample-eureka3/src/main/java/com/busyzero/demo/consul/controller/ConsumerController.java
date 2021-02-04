package com.busyzero.demo.consul.controller;

import com.busyzero.demo.consul.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private IHelloService helloService;
//    @Autowired
//    private RestTemplate restTemplate;

    private static final String applicationName = "single-provider";

    @RequestMapping(value = "/feignRequest")
    public Object feignRequest(){
        String s = helloService.nice();
        return s;
    }

    @RequestMapping(value = "/commonRequest")
    public Object commonRequest(){
        String url = "http://"+ applicationName +"/hello";
//        String s = restTemplate.getForObject(url,String.class);
        return url;
    }
}
