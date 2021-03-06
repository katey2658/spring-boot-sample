package com.busyzero.demo.springbootsampledemo4;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取直接所有属性和方法
        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(ConditionOnSystemProperty.class.getName());
        // 获取name方法值
        String propertyName = (String) attributes.getFirst("name");
        // 获取注解 value 值
        String propertyValue = (String) attributes.getFirst("value");
        // 获取系统属性值
        String systemPropertyValue = System.getProperty(propertyName);
        if (Objects.equals(systemPropertyValue, propertyValue)) {
            System.out.printf("系统属性【名称：%s】找到匹配值 %s \n", propertyName, propertyValue);
            return  true;
        }
        return false;
    }
}
