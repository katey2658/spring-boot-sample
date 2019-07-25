package com.busyzero.demo.formatter;

public class DefaultFormatter implements  Formatter {

    public String format(Object object) {
        return String.valueOf(object);
    }
}
