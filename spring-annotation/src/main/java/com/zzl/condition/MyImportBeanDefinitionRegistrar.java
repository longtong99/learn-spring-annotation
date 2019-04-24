package com.zzl.condition;/**
 * Created by admin on 2019/4/24.
 */

import com.zzl.bean.Rainbow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zzl
 * @version 1.0
 * @desception 手动注册bean
 * @date 2019/4/24 17:23
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 		把所有需要添加到容器中的bean；调用
     * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean beanDefinition = registry.containsBeanDefinition("com.zzl.bean.Red");
        boolean beanDefinition1 = registry.containsBeanDefinition("com.zzl.bean.Yellow");
        //当容器中包含com.zzl.bean.Red和com.zzl.bean.Yellow的时候，把Rainbow注册进去
        if(beanDefinition && beanDefinition1){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            registry.registerBeanDefinition("rainbow",rootBeanDefinition);
        }
    }
}
