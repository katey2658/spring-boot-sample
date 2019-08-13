package com.busyzero.demo.javaassist;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationHandler {

    private Invoker invoker;

    public InvocationHandler(Invoker invoker) {
        this.invoker = invoker;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        if (method.getName().equals("sayHello")) {
            return "sayHello";
        }
        if (method.getName().equals("sayBye")) {
            return "sayBye";
        }

        if (method.getName().equals("equals") || method.getName().equals("hasCode")) {
            try {
                method.invoke(proxy, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        String methodName = method.getName();
        Invocation invocation = new Invocation();
        invocation.setMethodName(methodName);

        Result result = invoker.invoke(invocation);
        return result.getData();
    }
}
