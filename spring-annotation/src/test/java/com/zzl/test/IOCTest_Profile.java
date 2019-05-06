package com.zzl.test;/**
 * Created by admin on 2019/4/29.
 */

import com.zzl.bean.Person;
import com.zzl.mainconfig.MainConfigOfProfile;
import com.zzl.mainconfig.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/29 18:22
 */
public class IOCTest_Profile {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name:names){
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        //这里必须是无参构造器，然后修改环境变量的值，然后重写有参构造器的方法
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(MainConfigOfProfile.class);
        context.refresh();
        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name:names){
            System.out.println(name);
        }
    }

    @Test
    public void test03(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] names = context.getBeanNamesForType(DataSource.class);
        for (String name:names){
            System.out.println(name);
        }
    }

}
