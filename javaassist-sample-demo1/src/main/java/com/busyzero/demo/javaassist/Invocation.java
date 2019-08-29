package com.busyzero.demo.javaassist;

import java.io.Serializable;

public class Invocation implements Serializable {
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] arguments;
    private String serviceName;

    public Invocation() {
    }

    public Invocation(String methodName, Class<?>[] parameterTypes, Object[] arguments, String serviceName) {
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.arguments = arguments;
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
