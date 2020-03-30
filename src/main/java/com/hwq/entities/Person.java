package com.hwq.entities;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *测试application.yml文件
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties 告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定，默认从全局配置文件中获取值
 * prefix="person" 表示从配置文件中那个下面的所有属性进行一一映射
 *
 * @Validated 表示对属性的注入值进行校验，例如在lastName上加上@Email，就会对这个lastName做邮箱格式校验
 *
 * 只有这个组件是容器中的组件才能容器提供的 @ConfigurationProperties  功能
 */
//@PropertySource(value = {"xxx.properties"}) //这个注解可以指定配置文件
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {
//    @Email
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String,Object>maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
