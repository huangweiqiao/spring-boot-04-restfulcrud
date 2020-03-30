package com.hwq.config;

import com.hwq.filter.MyFilter;
import com.hwq.listener.MyListener;
import com.hwq.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件

    //注册servlet
    @Bean
    public ServletRegistrationBean myServletBean(){
        //http://localhost:8080/myServlet
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new MyServlet(),"/myServlet"
        );
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;

    }

    //注册过滤器
    @Bean
    public FilterRegistrationBean myFilterBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));//要拦截哪些路径
        return filterRegistrationBean;
    }

    //注册监听器
    @Bean
    public ServletListenerRegistrationBean myListenerBean(){
        ServletListenerRegistrationBean <MyListener>servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;

    }

    // 配置嵌入式的servlet容器，通过在属性文件中配置 server.xxx 就可以改变相关的配置，和这里的效果是一样的
  /* @Bean
    public EmbeddedServletContainerCustomizer EmbeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer(){
            //定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8083);
            }
        };
    }
    */
}
