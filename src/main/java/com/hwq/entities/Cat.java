package com.hwq.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Value 不但支持从配置文件中注入值，还能支持spel 计算表达式
 * @Value 不能对负责类型进行取值，例如如果时map类型，那么就不能想配置文件中获取了。
 */
@Component
public class Cat {
    @Value("${cat.name}")
    private String name;
    @Value("#{11 * 2}")
    private int age;
    @Value("true")
    private Boolean isCute;

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

    public Boolean getCute() {
        return isCute;
    }

    public void setCute(Boolean cute) {
        isCute = cute;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isCute=" + isCute +
                '}';
    }
}
