package com.busyzero.demo;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 10:44 下午
 */
public class ServerImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ImportSelector importSelector = new ServerImportSelector();
        String[] selectClassNames = importSelector.selectImports(importingClassMetadata);
        Stream.of(selectClassNames)
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> {
                    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
                });
    }
}
