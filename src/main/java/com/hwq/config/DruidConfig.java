package com.hwq.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 因为使用了指定的数据源，而指定的数据源有很多自己的属性，这些属性 spirngboot 不知道的，
 * 因此关联不上，如果需要使用这些特殊的属性则需要自己写beanconfig创建数据源对象
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

   //配置Druid的监控,这样可以访问监控 http://localhost:8080/druid
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> map = new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow",""); //默认运行所有人访问
//        map.put("deny","192.168.14.21"); //拒绝谁访问
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }
    //2、配置一个web监控的filter
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> intiParams = new HashMap<>();
        intiParams.put("exclusions","*.jsp,*.css,*.html,/druid/*"); //配置哪些请求不拦截
        bean.setInitParameters(intiParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
