package com.busyzero.demo.v11;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

public class MyDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<String> loadFactoryNames = SpringFactoriesLoader.loadFactoryNames(EnableKrAutoConfiguration.class, classLoader);

        loadFactoryNames.add("com.busyzero.demo.v11..SelectedBean");

        return loadFactoryNames.toArray(new String[loadFactoryNames.size()]);
    }
}
