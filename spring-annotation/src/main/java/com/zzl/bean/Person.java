package com.zzl.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 给bean赋值的方式是通过@Value注解
 * 他的参数有三种类型
 *      1、直接写值
 *      2、#{运算表达式}
 *      3、${环境中的变量}
 */
public class Person {

	@Value("张三")
	private String name;
	@Value("#{20-2}")
	private Integer age;

	@Value("${person.nickName}")
	private String nickName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
	}


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
