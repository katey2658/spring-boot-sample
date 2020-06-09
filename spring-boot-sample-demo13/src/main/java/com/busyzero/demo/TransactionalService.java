package com.busyzero.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 4:06 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Service
@Transactional
public @interface TransactionalService {

    String name() default "";
}
