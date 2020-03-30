package com.hwq.component;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 * 实现国际化效果就是根据LocaleResolver来的，默认国际化解析器是根据http请求头的里语言来的，
 * 要实现自己的国际化解析器则请求的参数里要加上参数例如 l=zh_CN ,   http://localhost:8080/index.html?l=zh_CN
 * resolveLocale方法里就截取字符生成Locale对象即可
 *
 * 第一步：编写国际化资源文件
 * 第二步：在页面上去资源文件里的属性
 * 第三步：编写LocaleResolver组件
 * 第四部：将组件增加到容器中  (MyMvcConfig类里有生成该对象的方法)
 * 第五部：请求路径加 l=zh_CN  或者 l=en_US
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();
        if (!StringUtils.isEmpty(l)){
            String [] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
