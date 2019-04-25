package com.zzl.mainconfig;/**
 * Created by admin on 2019/4/25.
 */

import com.zzl.bean.Car;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/25 18:05
 */
@Configuration
@ComponentScan(basePackages = "com.zzl.bean")
public class MainConfigOfLiefCycle {


    @Bean(initMethod = "init",destroyMethod = "destroy")
    //@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Car car(){
        return new Car();
    }

}
