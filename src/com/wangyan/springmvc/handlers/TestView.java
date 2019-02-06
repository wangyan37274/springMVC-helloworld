package com.wangyan.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: wangyan
 * @Date: 2019/1/17
 * @Description: 视图和视图解析器
 * @version: 1.0
 */
@Controller
@RequestMapping("/view")
public class TestView {

    private static final String SUCCESS = "success";

    /**
     * 观察spring mvc 底层执行流程
     * @return
     */
    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }
    @RequestMapping("/testMyView")
    public String testMyView(){
        System.out.println("testMyView");
        return "helloView";//类名小写
    }

    /**
     * 重定向
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }
}
