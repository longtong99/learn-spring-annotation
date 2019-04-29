package com.zzl.test;/**
 * Created by admin on 2019/4/29.
 */

import com.zzl.bean.Person;
import com.zzl.mainconfig.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/29 18:22
 */
public class IOCTest_PropertyValue {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        printBeans(context);
        System.out.println("----------------------");
        Person person = (Person)context.getBean("person");
        System.out.println(person);
        //获取环境变量
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

}
