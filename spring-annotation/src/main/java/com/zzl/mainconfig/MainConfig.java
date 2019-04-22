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
 * @author zzl 配置类
 */
@Configuration
@ComponentScans(value = {
		@ComponentScan(value = "com.zzl", /*
											 * excludeFilters={
											 * //排除掉用Controller和Service注解的类
											 * 
											 * @Filter(type=FilterType.
											 * ANNOTATION,classes={Controller.
											 * class,Service.class}) }
											 */
				// 只包含BookController类
				/*includeFilters = { @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
						BookController.class }) }, useDefaultFilters = false*/
				includeFilters = {@Filter(type = FilterType.CUSTOM,classes=MyTypeFilter.class)},useDefaultFilters=false)

})
// @ComponentScan value:指定要扫描的包
// excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
// includeFilters = Filter[]
// ：指定扫描的时候只需要包含哪些组件,useDefaultFilters这个参数在设置includeFilters的时候必须设置为false，默认是true
// FilterType.ANNOTATION：按照注解，例如@Controller,@Service
// FilterType.ASSIGNABLE_TYPE：按照给定的类型；例如BookController
// FilterType.ASPECTJ：使用ASPECTJ表达式
// FilterType.REGEX：使用正则指定
// FilterType.CUSTOM：使用自定义规则
public class MainConfig {

	/**
	 * 
	 * @return 给容器中注册一个Bean; 类型为返回值的类型， id默认是用方法名作为id
	 */
	@Bean("person11")
	public Person person() {
		return new Person("lisi", 20);
	}

}
