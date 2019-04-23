package com.zzl.test;

import com.zzl.bean.Person;
import com.zzl.mainconfig.MainConfig0;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zzl.mainconfig.MainConfig;
import com.zzl.mainconfig.MainConfig2;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest {

	@SuppressWarnings("resource")
	@Test
	public void test01(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
		String[] names = context.getBeanDefinitionNames();
		for(String name : names){
			System.out.println(name);
		}
	}

	@SuppressWarnings("resource")
	@Test
	public void test02(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
		System.out.println("IOC容器初始化完成");
		//默认是单实例
		Object person1 = context.getBean("person");
		Object person2 = context.getBean("person");
		//这里打印true
		System.out.println(person1==person2);
	}

    @SuppressWarnings("resource")
    @Test
    public void test03(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        ConfigurableEnvironment environment =context.getEnvironment();
        //运行环境 Windows 10
        String environmentName = environment.getProperty("os.name");
        System.out.println(environmentName);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType){
            System.out.println(name);
        }
    }


}