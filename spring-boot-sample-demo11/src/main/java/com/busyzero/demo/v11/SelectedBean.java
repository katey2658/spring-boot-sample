package com.busyzero.demo.v11;

import org.springframework.beans.factory.annotation.Value;

public class SelectedBean {

    @Value("${spring.profiles.active:dev}")
    private String serverName;

    public String getDesc() {
        return "这是被选中的bean: " + serverName;
    }
}
