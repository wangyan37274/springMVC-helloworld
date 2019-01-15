package com.wangyan.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: wangyan
 * @Date: 2019/1/15
 * @Description: com.wangyan.springmvc.handlers
 * @version: 1.0
 */
@Controller
public class HelloWorld {

    /**
     * 1，使用@RequestMapping注解来映射请求的url
     * 2，返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下处理：
     * 通过prefix + returnVal + 后缀 这样的方式得到实际的物理视图，然后做转发操作
     * /WEB-INF/pages/success.jsp
     *
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){

        System.out.println("hello..springMVC!");
        return "success";
    }
}
