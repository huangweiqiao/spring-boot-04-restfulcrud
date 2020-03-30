package com.hwq;


import com.hwq.entities.Cat;
import com.hwq.entities.Person;
import com.hwq.entities.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * SpringBoot单元测试;
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    Student student;

    @Autowired
    Cat cat;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        /**
         * 在springboot的启动类SpringBoot04RestfulCurdApplication上
         * 加入了 @ImportResource(locations = {"classpath:beans.xml"})，这里就可以打印ture,
         * 表示helloService已经被spring容器管理了
         */
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void testBeanCreateService(){
        System.out.println("testBeanCreateService");
        boolean b = ioc.containsBean("beanCreateService");
        System.out.println(b);
    }


    @Test
    public void contextLoads() {
        System.out.println(person);
        System.out.println(student);
        System.out.println(cat);
    }

}
