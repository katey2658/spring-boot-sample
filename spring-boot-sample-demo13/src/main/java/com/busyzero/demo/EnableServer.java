package com.busyzero.demo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 10:33 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ServerImportBeanDefinitionRegister.class)
public @interface EnableServer {

    Server.Type type();
}
