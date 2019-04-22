package com.zzl.mainconfig;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.zzl.bean.Person;

@Configuration
public class MainConfig2 {
	/**
	 *
	 * @return
	 * * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON singleton
	 * @see org.springframework.web.context.WebApplicationContext #SCOPE_REQUEST request
	 * @see org.springframework.web.context.WebApplicationContext #SCOPE_SESSION session
	 *
	 * prototype:多实例的,这种情况下，只有在用到对象的时候才会创建
	 *
	 * singleton:单实例的（默认值），这种情况下，在IOC容器加载的时候对象就会创建，以后使用直接在IOC容器中拿
	 *
	 * request:一个请求创建一次
	 *
	 * session:一个session创建一个
	 *
	 *
	 */
	//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Lazy
	@Bean
	public Person person(){
		System.out.println("创建Person对象。。。。。");
		return new Person("张三",26);
	}

}