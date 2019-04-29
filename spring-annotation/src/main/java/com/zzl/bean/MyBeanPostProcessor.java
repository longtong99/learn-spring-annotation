package com.zzl.bean;/**
 * Created by admin on 2019/4/29.
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zzl
 * @version 1.0
 * @desception 后置处理器：初始化前后进行处理工作，对所有注入IOC的bean都会生效
 * @date 2019/4/29 14:03
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    //再实例初始化之前调用
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..."+beanName+"=>"+bean);
        return bean;
    }
    //再实例初始化之后调用
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..."+beanName+"=>"+bean);
        return bean;
    }
}
