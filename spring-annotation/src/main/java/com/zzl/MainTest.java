package com.zzl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzl.bean.Person;
import com.zzl.mainconfig.MainConfig;
import com.zzl.mainconfig.MainConfig0;

public class MainTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 配置文件方式
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("beans.xml"); Object person =
		 * context.getBean("person");
		 */
		// 注解的方式
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
		Person person = context.getBean(Person.class);
		System.out.println(person);
		String[] names = context.getBeanNamesForType(Person.class);
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	

}
