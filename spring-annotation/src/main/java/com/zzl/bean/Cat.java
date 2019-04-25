package com.zzl.bean;/**
 * Created by admin on 2019/4/25.
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/25 18:48
 */
@Component
public class Cat implements InitializingBean,DisposableBean {

    public Cat(){
        System.out.println("cat constructor...");
    }

    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }
}
