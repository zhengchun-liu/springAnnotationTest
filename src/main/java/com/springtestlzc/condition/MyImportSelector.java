package com.springtestlzc.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //不要返回null，会空指针异常
        return new String[]{"com.springtestlzc.beans.Yellow", "com.springtestlzc.beans.Blue"};
    }
}
