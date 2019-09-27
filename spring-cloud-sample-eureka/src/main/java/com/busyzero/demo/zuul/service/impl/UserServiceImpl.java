package com.busyzero.demo.zuul.service.impl;

import com.busyzero.demo.stream.service.UserService;
import com.busyzero.demo.stream.utils.UserContextHolder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {


    @HystrixCommand(fallbackMethod = "getFallbackName",
            threadPoolKey = "getNameTHreadPool",
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //10s 内必须调用数量
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdLPercentage", value = "75"), // 超时，异常 ，或者500 百分比
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMillseconds", value = "7000"), // 在尝试重新调用之前的窗口期
//                    @HystrixProperty(name = "metrics.rollingStats.timeInMillseconds", value = "15000"), // 监视服务调用的窗口大小
//                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5"), // 收集信息的大小
            })
    @Override
    public String getName() {
        Random random = new Random();
        int randomNum = random.nextInt((3 - 1) + 1) + 1;
        if (randomNum == 3) {
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return UserContextHolder.curUserContenxt().getUserId();

    }

    private String getFallbackName() {
        return "fallbackName";
    }
}
