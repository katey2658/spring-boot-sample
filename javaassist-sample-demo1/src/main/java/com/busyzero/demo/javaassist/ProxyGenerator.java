package com.busyzero.demo.javaassist;

import javassist.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ProxyGenerator {
    private static final AtomicInteger counter = new AtomicInteger(1);

    private static ConcurrentHashMap<Class<?>, Object> proxyInstanceCache = new ConcurrentHashMap<>();

    public static Object newProxyInstance(ClassLoader classLoader, Class<?> targetClass, InvocationHandler invocationHandler)
            throws Exception {
        if(proxyInstanceCache.containsKey(targetClass)){
            return proxyInstanceCache.get(targetClass);
        }

        ClassPool pool = ClassPool.getDefault();

        String qualifiedName = generateClassName(targetClass);
        CtClass proxy = pool.makeClass(qualifiedName);

        CtField mf = CtField.make("public static java.lang.reflect.Method[] methods;", proxy);
        proxy.addField(mf);

        CtField hf = CtField.make("private " + InvocationHandler.class.getName() + " handler;", proxy);
        proxy.addField(hf);

        CtConstructor constructor = new CtConstructor(new CtClass[]{pool.get(InvocationHandler.class.getName())}, proxy);
        constructor.setBody("this.handler=$1;");
        constructor.setModifiers(Modifier.PUBLIC);
        proxy.addConstructor(constructor);

        proxy.addConstructor(CtNewConstructor.defaultConstructor(proxy));

        List<Class<?>> interfaces = getAllInterfaces(targetClass);

        List<Method> methods = new ArrayList<>();

        for (Class<?> cls : interfaces) {
            CtClass ctClass = pool.get(cls.getName());
            proxy.addInterface(ctClass);

            Method[] arr = cls.getDeclaredMethods();
            for (Method method : arr) {
                int ix = methods.size();

                Class<?> rt = method.getReturnType();
                Class<?>[] pts = method.getParameterTypes();

                StringBuilder code = new StringBuilder("Object[] args = new Object[").append(pts.length).append("];");
                for (int j = 0; j < pts.length; j++) {
                    code.append("args[").append(j).append("] = ($w)$").append(j+1).append(";");
                }

                code.append(" Object ret = handler.invoke(this, methods[" + ix + "], args);");
                if (!Void.TYPE.equals(rt)) {
                    code.append(" return ").append("(" + getParameterType(rt) +")" + "ret").append(";");
                }

                StringBuilder sb= new StringBuilder(1024);
                sb.append("public").append(" ").append(getParameterType(rt)).append(" ").append(method.getName());
                sb.append("(");
                for (int i = 0; i < pts.length; i++) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(getParameterType(pts[i]));
                    sb.append(" arg").append(i);
                }
                sb.append(")");

                Class<?>[] ets = method.getExceptionTypes();
                if (ets != null && ets.length > 0) {
                    sb.append( "throws ");
                    for (int i = 0; i < ets.length; i++) {
                        if (i > 0) {
                            sb.append(",");
                        }
                        sb.append(getParameterType(ets[i]));
                    }
                }
                sb.append("{").append(code.toString()).append("}");

                CtMethod ctMethod = CtMethod.make(sb.toString(), proxy);
                proxy.addMethod(ctMethod);
                methods.add(method);
            }
        }

        proxy.setModifiers(Modifier.PUBLIC);
        Class<?> proxyClass = proxy.toClass();
        proxyClass.getField("methods").set(null, methods.toArray(new Method[0]));
        Object instance = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        proxyInstanceCache.put(targetClass, instance);
        return instance;
    }

    private static List<Class<?>> getAllInterfaces(Class<?> targetClass) {
        return Arrays.asList(targetClass);
    }

    private  static String getParameterType(Class<?> c) {
        if(c.isArray()) {   //数组类型
            StringBuilder sb = new StringBuilder();
            do {
                sb.append("[]");
                c = c.getComponentType();
            } while( c.isArray() );

            return c.getName() + sb.toString();
        }
        return c.getName();
    }

    private  static  String generateClassName(Class<?> type) {
        return String.format("%s$Proxy%d", type.getName(), counter.getAndIncrement());
    }
}
