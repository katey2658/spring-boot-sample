package com.busyzero.demo.javaassist;

public class JavassistProxyFactory extends AbstractProxyFactory {
    @Override
    public <T> T getProxy(Invoker<T> invoker, Class<?>[] interfaces) {
        return Proxy.getProxy(interfaces);
    }

    @Override
    public <T> Invoker<T> getInvoker(T proxy, Class<T> type, URL url) {
        Wrapper wrapper = Wrapper.getWrapper(proxy.getClass());
        return new AbstractProxyInvoker<T>(proxy, type, url) {
            @Override
            protected Object doInvoke(T proxy, String methodName, Class<?>[] parameterTypes, Object[] arguments) throws Throwable{
                 return wrapper.invokeMethod(proxy, methodName, parameterTypes, arguments);
            }
        };
    }
}
