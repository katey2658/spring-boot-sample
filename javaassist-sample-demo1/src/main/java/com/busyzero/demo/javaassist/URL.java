package com.busyzero.demo.javaassist;

import java.util.HashMap;
import java.util.Map;

public class URL {
    private Integer weight;
    private String host;
    private Integer port;
    private Map<String, String> parameters = new HashMap<>();

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void addParameter(String paramKey, String value) {
         parameters.put(paramKey, value);
    }

    public String getParameter(String paramKey) {
        return parameters.get(paramKey);
    }
}
