package com.architect.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by BaiYuliang on 2017/7/1.
 */
@XmlRootElement(name = "user")
public class User {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + ", age=" + age + '}';
    }
}
