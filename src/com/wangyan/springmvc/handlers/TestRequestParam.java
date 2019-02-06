package com.wangyan.springmvc.handlers;

import com.wangyan.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: wangyan
 * @Date: 2019/1/15
 * @Description: 测试获取请求的参数（请求体），请求头，cookie，实体对象传参，servlet的API等信息
 * @version: 1.0
 */
@Controller
@RequestMapping("/rp")
public class TestRequestParam {

    private static final String SUCCESS = "success";

    /**
     * 在处理方法入参处使用 @RequestParam 可以把请求参数传递给请求方法
     * value：参数名
     * required：是否必须。默认为 true, 表示请求参数中必须包含对应的参数，若不存在，将抛出异常
     * defaultValue：设置默认值
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "username") String name,
            @RequestParam(value = "age",required = false,defaultValue = "0") Integer age
    ){
        System.out.println("name:"+name+"age:"+age);
        return SUCCESS;
    }

    /**
     * 请求头
     * @param encoding
     * @return
     */
    @RequestMapping(value = "testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Encoding") String encoding){
        System.out.println("encoding:"+encoding);
        return SUCCESS;
    }

    /**
     * cookie
     * @param JSESSIONID
     * @return
     */
    @RequestMapping(value = "testRequestCookie")
    public String testRequestCookie(@CookieValue(value = "JSESSIONID",required = false) String JSESSIONID){
        System.out.println("JSESSIONID:"+JSESSIONID);
        return SUCCESS;
    }

    /**
     * 实体对象传参
     * @param user
     * @return
     */
    @RequestMapping(value = "testPojo")
    public String testPojo(User user){
        System.out.println(user);
        return SUCCESS;
    }

    /**
     * servlet的API等信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "testServletApi")
    public String testServletApi(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request"+request+",response"+response);
        return SUCCESS;
    }

}
