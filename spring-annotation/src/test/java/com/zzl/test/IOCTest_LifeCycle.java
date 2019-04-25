package com.zzl.test;/**
 * Created by admin on 2019/4/25.
 */

import com.zzl.bean.Car;
import com.zzl.mainconfig.MainConfigOfLiefCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/25 18:19
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLiefCycle.class);
        System.out.println("容器创建完成");
        Car car = (Car) applicationContext.getBean("car");
        //关闭容器
        System.out.println("容器销毁之前");
        applicationContext.close();
        System.out.println("容器销毁完成");
        car.destroy();
    }


}
