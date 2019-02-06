package com.wangyan.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: wangyan
 * @Date: 2019/1/15
 * @Description: com.wangyan.springmvc.handlers
 * @version: 1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloWorld {

    private static final String SUCCESS = "success";

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
        return SUCCESS;
    }

    /**
     * 使用method属性指定请求方式
     * 请求必须是post才能匹配
     * @return
     */
    @RequestMapping(value = "testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 规定请求中的参数和头部
     * param1:表示请求必须包含名为param1的请求参数
     * !param1:表示请求不能包含名为param1的请求参数
     * param1!=value1:表示请求包含名为param1的请求参数，但其值不能为 value1
     * {“param1=value1”, “param2”}:请求必须包含名为param1和param2的两个请求参数，且param1参数的值必须为value1
     *
     */
    @RequestMapping(
        value = "testParamsAndHeaders",
        params = {"username","age!=10"},
        headers = {"Accept-Language=zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3"}
    )
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 测试占位符
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        System.out.println("占位符是："+id);
        return SUCCESS;
    }

    /**
     * Rest 风格的 URL         传统方式
     * 新增：/order POST
     * 删除：/order/1 DELETE   update?id=1
     * 修改：/order/1 PUT      delete?id=1
     * 查询：/order/1 GET      get?id=1
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id){
        System.out.println("get方式");
        System.out.println("占位符是："+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRestPost(){
        System.out.println("POST方式");
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("PUT方式");
        System.out.println("占位符是："+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("DELETE方式");
        System.out.println("占位符是："+id);
        return SUCCESS;
    }
}
