package com.zzl.mainconfig;/**
 * Created by admin on 2019/4/29.
 */

import com.zzl.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/29 18:20
 */
//@PropertySource读取外部配置文件中的属性到环境变量中，里面的路径是个数组，可以是相对路径，也可以是绝对路径
@PropertySource({"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {


    @Bean
    public Person person(){
        return new Person();
    }

}
