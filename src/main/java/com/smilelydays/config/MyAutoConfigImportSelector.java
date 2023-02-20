package com.smilelydays.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.smilelydays.config.autoconfig.DispatcherServletConfig",
                "com.smilelydays.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
