package com.busyzero.demo.v11;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(MyDeferredImportSelector.class)
public @interface EnableKrAutoConfiguration {
}
