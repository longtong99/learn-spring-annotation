package com.zzl.mainconfig;

import com.zzl.bean.Color;
import com.zzl.bean.ColorFactoryBean;
import com.zzl.bean.Red;
import com.zzl.condition.LinuxCondition;
import com.zzl.condition.MyImportBeanDefinitionRegistrar;
import com.zzl.condition.MyImportSelector;
import com.zzl.condition.WindowCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import com.zzl.bean.Person;

@Configuration
//类中组件统一设置，满足这个条件，类中组件才能被加载
//当然，如果这里满足了，下面方法也设置了@Conditional，并且不满足，那么对应的方法的bean也不会被加载
@Conditional({WindowCondition.class})
// @Import快速导入一个组件，组件的id默认值类的全类名,里面的参数是一个数组
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
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

    /**
     *  @Conditional{Condition} 注解：按照条件进行判断，满足条件才会给容器装载bean
     *
     *  如果是windows系统返回bill,
     *  如果是linux系统返回linus
     *
     */
    @Conditional({WindowCondition.class})
	@Bean("bill")
	public Person person1(){
	    return new Person("Bill Gates",66);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person2(){
        return new Person("Linus",66);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}