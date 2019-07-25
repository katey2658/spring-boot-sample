package com.busyzero.demo.springbootsampledemo4;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db.master", ignoreUnknownFields = true)
public class DataSourceProperties {

    private String driverClassName;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
