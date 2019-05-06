package com.zzl.test;/**
 * Created by admin on 2019/4/29.
 */

import com.zzl.bean.Person;
import com.zzl.dao.BookDao;
import com.zzl.mainconfig.MainConfigOfAutowired;
import com.zzl.mainconfig.MainConfigOfPropertyValues;
import com.zzl.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zzl
 * @version 1.0
 * @desception
 * @date 2019/4/29 18:22
 */
public class IOCTest_Autowired {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);
    }



}
