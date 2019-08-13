package com.busyzero.demo.javaassist;


public class AppMain {
    public static void main(String[] args) {

        SayService sayService = Proxy.getBean(SayService.class);
        String result = sayService.sayHello("hi");
        System.out.println(result);
        try {
            result = sayService.say("say what");
            System.out.println(result);


            result = sayService.sayBye("bye");
            System.out.println(result);

            System.out.println(sayService.equals("hh"));

            System.out.println(sayService.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JumpService jumpService = Proxy.getBean(JumpService.class);
        System.out.println(jumpService.jumpOne());
        System.out.println(jumpService.jumpSay("哈哈哈"));

        try {
            System.out.println(jumpService.equals("tt"));
            System.out.println(jumpService.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

        sayService = Proxy.getBean(SayService.class);
        try {
            System.out.println(sayService.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
