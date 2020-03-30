package com.hwq.config;

import com.hwq.component.LoginHandlerInterceptor;
import com.hwq.component.MyLocaleResolver;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 通过使用WebMvcConfigurerAdapter扩展springmvc的功能 ,这个类不能标注 @EnableWebMvc ,
 * 如果配置了@EnableWebMvc springboot的默认mvc配置则失效了
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /hwq 请求则来到 success 页面
        registry.addViewController("/hwq").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter(){

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // addPathPatterns("/**") 表示所有路径都拦，excludePathPatterns 表示排除掉指定的路径
                // 静态资源 springboot已经帮我们处理了，不需要我们像springmvc一样还要一一排除
              /*  registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/index","/","/user/login","/hello","/success");*/
            }

        };


    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
