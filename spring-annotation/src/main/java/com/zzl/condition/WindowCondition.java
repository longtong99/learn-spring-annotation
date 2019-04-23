package com.zzl.condition;/**
 * Created by admin on 2019/4/23.
 */

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zzl
 * @version 1.0
 * @desception  判断操作系统是否是Windows
 * @date 2019/4/23 18:13
 */
public class WindowCondition implements Condition{
    /**
     * 当运行环境是Windows的时候返回true
     * @param context
     * @param metadata
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1、获取IOC容器的beanfactory
        ConfigurableListableBeanFactory configurableListableBeanFactory =  context.getBeanFactory();
        // 2、获取类加载器
        ClassLoader classLoader =  context.getClassLoader();
        // 3、获取bean的注册类，这个类可以给容器注册bean,可以移除容器的bean,可以查看有哪些bean注册到了容器
        BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();
        // 4、获取当前的环境信息
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        if(osName!=null && osName.contains("Windows"))
            return true;
        return false;
    }
}
