package com.hwq.controller;

import com.hwq.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理期，出现异常统一有该类处理
 */
@ControllerAdvice
public class MyExceptionHandler {

    //这种方式 不管是浏览器访问还是客户端访问，这里返回的都是json格式的字符串
   /* @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    public Map handleException(Exception e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/




    //转发到 /error，这时springboot会自适应，根据请求头里的 accept 来决定是返回页面形式还时返回json 格式
    //这样 返回给浏览器是普通的页面显示数据，返回给客户端则是json字符串
    /*@ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        //因为springboot的错误处理组件种会根据 javax.servlet.error.status_code 来判断http的状态码，因此这里设置状态码
        request.setAttribute("javax.servlet.error.status_code","500");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","user.notexist");
        map.put("message","用户出错了"); //注意页面上其实显示不了这个消息，显示的还是UserNotExistException里的消息
        //转发到 /error
        return "forword:/error";
    }*/




    //出现错误后，会来到/error请求，会被 BasicErrorController处理，响应出去可以获取的数据是由getErrorAttributes得到的（是AbstractErrorController 规定的方法）；
    //1、完全来编写一个ErrorController的实现类【或者是编写AbstractErrorController的子类】，放再容器中；
    //2、页面上能用的数据，或者json返回能用的数据都是通过errorAttributes.getErrorAttributes得到的
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        //因为springboot的错误处理组件种会根据 javax.servlet.error.status_code 来判断http的状态码，因此这里设置状态码
        request.setAttribute("javax.servlet.error.status_code","500");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","user.notexist");
        map.put("message","用户出错了");
        request.setAttribute("ext",map);
        //转发到 /error
        return "forword:/error";
    }

}
