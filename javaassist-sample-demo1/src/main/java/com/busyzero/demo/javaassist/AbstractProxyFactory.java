package com.busyzero.demo.javaassist;

import java.util.regex.Pattern;

public abstract class AbstractProxyFactory implements ProxyFactory {
    @Override
    public <T> T getProxy(Invoker<T> invoker) {
        Class<?>[] ifaces = null;
        String config = invoker.getUrl().getParameter("interfaces");
        if (config != null && config.length() > 0) {
           String[] types = Pattern.compile("\\s*[,]+\\s*").split(config);
           if (types != null && types.length > 0) {
               ifaces = new Class<?>[types.length + 2];
               ifaces[0] = invoker.getInterface();
               ifaces[1] = EchoService.class;
               for (int i = 0; i < types.length; i++) {
                   try {
                       ifaces[i+ 2] = Class.forName(types[i]);
                   } catch (ClassNotFoundException e) {
                       e.printStackTrace();
                   }
               }
           }
        }
        if (ifaces == null) {
            ifaces = new Class[]{invoker.getInterface(), EchoService.class};
        }
        return getProxy(invoker, ifaces);
    }

    public abstract <T> T getProxy(Invoker<T> invoker, Class<?>[] types);
}
