package com.busyzero.demo.formatter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFormatter implements  Formatter {

    private final ObjectMapper objectMapper;

    public JsonFormatter(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public String format(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
