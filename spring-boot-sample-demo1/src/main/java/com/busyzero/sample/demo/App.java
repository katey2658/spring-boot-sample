package com.busyzero.sample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
@CrossOrigin()
@RestController
@SpringBootApplication
public class App {

    @RequestMapping("/")
    public String index() {
        return "Hello Json";
    }

    @GetMapping(value = "/data")
    public Map getDat() {
        Map<String, Object> data1 = new HashMap<>();
        data1.put("name", 1001);
        data1.put("setup", "我是setup");
        data1.put("punchline", "我是punchline");
        List<Map> mapList = new ArrayList<>();
        mapList.add(data1);
        return data1;
    }


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
