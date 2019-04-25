package com.zzl.bean;/**
 * Created by admin on 2019/4/24.
 */

import org.springframework.beans.factory.FactoryBean;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/24 18:10
 */
public class ColorFactoryBean implements FactoryBean<Color>{
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean ...");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
