package com.busyzero.demo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author wangdong
 * @mail katey2658@163.com
 * @date 2020/6/7 10:33 下午
 */
public class ServerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 读取EnableServer 中的全部属性，
        // key 是属性名 ，val 是值
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        String[] importClassName = new String[0];
        switch (type) {
            case HTTP:
                importClassName = new String[]{HttpServer.class.getName()};
                break;
            case FTP:
                importClassName = new String[]{FtpServer.class.getName()};
                break;
        }
        return importClassName;
    }
}
