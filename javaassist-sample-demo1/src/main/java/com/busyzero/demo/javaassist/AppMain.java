package com.busyzero.demo.javaassist;


public class AppMain {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new JavassistProxyFactory();

        SayService sayService = new SayService() {
            @Override
            public String sayHello(String sayHello) {
                return "哈哈哈";
            }

            @Override
            public String sayBye(String sayBye) throws Exception {
                return "黑河";
            }

            @Override
            public String say(String say) throws Exception {
                return "😁";
            }
        };

        Invoker<SayService> invoker = proxyFactory.getInvoker(sayService, SayService.class, null);
        Invocation invocation = new Invocation();
        invocation.setMethodName("sayHello");
        invocation.setArguments(new Object[]{"说话"});
        invocation.setParameterTypes(new Class[]{String.class});
        System.out.println(invoker.invoke(invocation).getData());


//
//        RpcInvoker<SayService> rpcInvoker = new RpcInvoker<>();
//        rpcInvoker.setIface(SayService.class);
//
//        SayService sayService = proxyFactory.getProxy(rpcInvoker);
//
//
//        String result = sayService.sayHello("hi");
//        System.out.println(result);
//        try {
//            result = sayService.say("say what");
//            System.out.println(result);
//
//
//            result = sayService.sayBye("bye");
//            System.out.println(result);
//
//            System.out.println(sayService.equals("hh"));
//
//            System.out.println(sayService.hashCode());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JumpService jumpService = Proxy.getProxy(JumpService.class);
//        System.out.println(jumpService.jumpOne());
//        System.out.println(jumpService.jumpSay("哈哈哈"));
//
//        try {
//            System.out.println(jumpService.equals("tt"));
//            System.out.println(jumpService.hashCode());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        sayService = Proxy.getProxy(SayService.class);
//        try {
//            System.out.println(sayService.hashCode());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
