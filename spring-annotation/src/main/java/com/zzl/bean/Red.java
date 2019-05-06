package com.zzl.bean;/**
 * Created by admin on 2019/4/24.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/24 17:08
 */
@Component
public class Red implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    public void setBeanName(String name) {
        System.out.println("当前bean的名字："+name);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("传入的ioc："+applicationContext);
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println(resolver.resolveStringValue("你好:${os.name}，这是#{18*18}"));
    }
}
