package com.busyzero.demo.javaassist.demo;

import javassist.*;

public class Proxy {

    public static void createPersion() throws Exception{
        ClassPool pool = ClassPool.getDefault();

        CtClass cc = pool.makeClass("com.busyzero.demo.javaassist.demo.Person");

        CtField field = new CtField(pool.get("java.lang.String"), "nickName", cc);
        field.setModifiers(Modifier.PRIVATE);
        cc.addField(field, CtField.Initializer.constant("katey2658"));

        cc.addMethod(CtNewMethod.setter("setNikName", field));
        cc.addMethod(CtNewMethod.getter("getNikName", field));

        CtConstructor constructor = new CtConstructor(new CtClass[]{}, cc);
        constructor.setBody("{$0.nickName = \"dongdong\";}");
        cc.addConstructor(constructor);

        constructor = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, cc);
        constructor.setBody("{$0.nickName = $1;}");
        cc.addConstructor(constructor);

        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printNickName", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(this.nickName);}");
        cc.addMethod(ctMethod);

        cc.writeFile("/Users/pxcm-0101-01-0076/work/source/sample-demo/javaassist-sample-demo1/src/main/java/");
    }

    public static void main(String[] args) {
        try {
            Proxy.createPersion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
