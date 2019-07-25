package com.busyzero.demo.springbootsampledemo4;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionOnSystemProperty {

    /** 属性名称 */
    String name();

    /** 属性值 */
    String value();
}
