package com.zzl.mainconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zzl.bean.Person;

@Configuration
public class MainConfig0 {
	
	@Bean("person111")
	public Person person(){
		return new Person("ss",11);
	}

}
