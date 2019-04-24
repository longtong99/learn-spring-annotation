package com.zzl.condition;/**
 * Created by admin on 2019/4/24.
 */

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zzl
 * @version 1.0
 * @desception 自定义逻辑返回需要导入的组件
 * @date 2019/4/24 17:20
 */
public class MyImportSelector implements ImportSelector {
    //返回值，就是到导入到容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //importingClassMetadata
        //方法不要返回null值
        return new String[]{"com.zzl.bean.Blue","com.zzl.bean.Yellow"};
    }
}
