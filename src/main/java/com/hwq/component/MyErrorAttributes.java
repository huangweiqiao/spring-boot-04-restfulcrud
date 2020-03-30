package com.hwq.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * 自定义ErrorAttributes 改变默认行为
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        //这里可以自己加信息
        errorAttributes.put("website","hwq.com");
        //异常处理器携带的数据
        Map<String,Object> ext = (Map<String,Object>)requestAttributes.getAttribute("ext",RequestAttributes.SCOPE_REQUEST);
        errorAttributes.put("ext",ext);
        return errorAttributes;
    }
}
