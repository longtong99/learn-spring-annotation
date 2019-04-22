package com.zzl.mainconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.zzl.bean.Person;
import com.zzl.controller.BookController;

/**
 * 
 * @author zzl ������
 */
@Configuration
@ComponentScans(value = {
		@ComponentScan(value = "com.zzl", /*
											 * excludeFilters={
											 * //�ų�����Controller��Serviceע�����
											 * 
											 * @Filter(type=FilterType.
											 * ANNOTATION,classes={Controller.
											 * class,Service.class}) }
											 */
				// ֻ����BookController��
				/*includeFilters = { @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
						BookController.class }) }, useDefaultFilters = false*/
				includeFilters = {@Filter(type = FilterType.CUSTOM,classes=MyTypeFilter.class)},useDefaultFilters=false)

})
// @ComponentScan value:ָ��Ҫɨ��İ�
// excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
// includeFilters = Filter[]
// ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ���,useDefaultFilters�������������includeFilters��ʱ���������Ϊfalse��Ĭ����true
// FilterType.ANNOTATION������ע�⣬����@Controller,@Service
// FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�����BookController
// FilterType.ASPECTJ��ʹ��ASPECTJ���ʽ
// FilterType.REGEX��ʹ������ָ��
// FilterType.CUSTOM��ʹ���Զ������
public class MainConfig {

	/**
	 * 
	 * @return ��������ע��һ��Bean; ����Ϊ����ֵ�����ͣ� idĬ�����÷�������Ϊid
	 */
	@Bean("person11")
	public Person person() {
		return new Person("lisi", 20);
	}

}
