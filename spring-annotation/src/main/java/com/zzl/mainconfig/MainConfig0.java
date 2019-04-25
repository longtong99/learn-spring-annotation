package com.zzl.mainconfig;

import com.zzl.bean.Color;
import com.zzl.bean.Red;
import com.zzl.condition.LinuxCondition;
import com.zzl.condition.MyImportBeanDefinitionRegistrar;
import com.zzl.condition.MyImportSelector;
import com.zzl.condition.WindowCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import com.zzl.bean.Person;
import org.springframework.stereotype.Controller;

//@Controller
public class MainConfig0 {
	@Bean
	public Color color(){
		return new Color();
	}

}