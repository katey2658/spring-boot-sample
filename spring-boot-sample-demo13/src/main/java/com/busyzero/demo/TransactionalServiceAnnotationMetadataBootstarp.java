package com.busyzero.demo;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import sun.reflect.misc.ReflectUtil;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 4:04 下午
 */
@TransactionalService(name = "myTest")
public class TransactionalServiceAnnotationMetadataBootstarp {
//    public static void main(String[] args) throws IOException {
//        String className = TransactionalServiceAnnotationMetadataBootstarp.class.getName();
//        // 构建 MetadataReaderFactory
//        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
//        // 读取 @TransactionalService  MetadataReader 信息
//        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
//        // 读取 annotationMetadata
//        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//        annotationMetadata.getAnnotationTypes().forEach(annotationType -> {
//            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
//
//            metaAnnotationTypes.forEach(metaAnnotationType -> {
//                System.out.printf(" 注解 @%s 元标注 @%s \n", annotationType, metaAnnotationType);
//            });
//        });

//        AnnotatedElement annotatedElement = TransactionalServiceAnnotationMetadataBootstarp.class;
//
//        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
//
//        String nameAttribute = transactionalService.name();
//        System.out.println(nameAttribute);
//
//        ReflectionUtils.doWithMethods(
//                TransactionalService.class,
//                method -> System.out.printf("@TransactionalService.%s() = %s \n", method.getName(), ReflectionUtils.invokeMethod(method, transactionalService)),
//                method -> !method.getDeclaringClass().equals(Annotation.class));
//
//        AnnotatedElement annotatedElement = TransactionalService.class;
//        AnnotationAttributes serviceAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Service.class);
//        AnnotationAttributes transactionalAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Service.class);
//        print(serviceAttributes);
//        print(transactionalAttributes);
//
//    }
//    private static void print(AnnotationAttributes annotationAttributes) {
//        System.out.printf("注解 @%s 属性集合 ：\n", annotationAttributes.annotationType().getName());
//
//        annotationAttributes.forEach((name, val) -> {
//            System.out.printf("\t 属性 %s : %s \n", name, val);
//        });
//    }
}
