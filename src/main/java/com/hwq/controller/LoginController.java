package com.hwq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value="/user/login") //这是新的注解方式表示post请求
//    @RequestMapping(value = "/user/login" ,method= RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
//            return "dashboard";
            //为了防止按F5 重复提交表单，可以使用重定向到页面 ,redirect:表示重定向,/ 表示当前路径下，main.html 在MyMvcConfig里有配置
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "index.html";
        }

    }
}
