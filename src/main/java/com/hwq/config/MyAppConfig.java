package com.hwq.config;


import com.hwq.service.BeanCreateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot推荐写配置类，而不是通过xml文件来创建对象，
 * @Configuration 指明当前类是一个配置类，就是用来替换之前的spring xml配置文件的，
 * 这样就不用beans.xml
 */
@Configuration
public class MyAppConfig {

    @Bean
    public BeanCreateService beanCreateService(){
        //对象名字就是方法名，类似xml 文件中 bean 的 id
        return new BeanCreateService();
    }
}
