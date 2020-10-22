package com.busyzero.demo.eureka.controller;

import com.busyzero.demo.eureka.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
