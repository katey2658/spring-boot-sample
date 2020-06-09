package com.busyzero.demo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 9:56 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DelegationHelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
