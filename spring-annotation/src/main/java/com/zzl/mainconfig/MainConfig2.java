package com.zzl.mainconfig;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.zzl.bean.Person;

@Configuration
public class MainConfig2 {
	/**
	 * 
	 * @return
	 * * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON singleton
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
	 * 
	 * prototype:��ʵ����,��������£�ֻ�����õ������ʱ��Żᴴ��
	 * 
	 * singleton:��ʵ���ģ�Ĭ��ֵ������������£���IOC�������ص�ʱ�����ͻᴴ�����Ժ�ʹ��ֱ����IOC��������
	 * 
	 * request:һ�����󴴽�һ��
	 * 
	 * session:һ��session����һ��
	 * 
	 * 
	 */
	//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public Person person(){
		System.out.println("����Person���󡣡�������");
		return new Person("����",26);
	}
	
}
