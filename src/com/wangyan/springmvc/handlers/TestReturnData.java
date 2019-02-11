package com.wangyan.springmvc.handlers;

import com.wangyan.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Auther: wangyan
 * @Date: 2019/1/16
 * @Description: 处理模型数据
 * @version: 1.0
 */
@SessionAttributes(value = {"user"},types = {String.class})//把请求域中的值放到session中
@Controller
@RequestMapping("/rd")
public class TestReturnData {

    private static final String SUCCESS = "success";

    /**
     * 测试 ModelAndView
     * spring mvc 会把 modelAndView 的 model 中数据放入到 request 域对象中。
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        //向modelAndView中添加要返回的数据
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }

    /**
     * 测试Map
     * 目标方法可以添加 map 类型的参数。
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("names", Arrays.asList("Tom","Jerry","mike"));
        return SUCCESS;
    }

    /**
     * 测试 SessionAttributes
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外，(使用的value属性值)
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（使用的type属性值）
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map){
        User user = new User(1,"wangyan","123","wangyan.com",12,null);
        /**
         * 参数中的map，是模型对象，最后放到request域中；
         * 由于类上有@SessionAttributes(value = {"user"},types = {String.class})注解
         * 相当于在服务端new session对象，并把设置session对象属性，user=user，school=ligong
         */
        map.put("user",user);//对应session中的user
        map.put("school","ligong");//对应session的String.class
        return SUCCESS;
    }

    /**
     * @ModelAttribute 方法的执行流程
     * 1，执行@ModelAttribute注解的方法，从数据库中查出一个user，并把user放进了map中
     * 2，spring mvc 把map中的user取出，赋值给方法参数上的user
     * 3，把表单中的user再赋值给这个user
     * 也就是说，方法中的参数user不是new出来的，而是@ModelAttribute方法里的map中的user
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "usercba") User user){
        System.out.println("修改："+user);
        return SUCCESS;
    }

    /**
     * 有 @ModelAttribute 标记的方法，会在每个目标方法执行之前被 spring mvc 调用
     * @ModelAttribute 也可以修饰POJO类型的入参，其value属性值有如下的作用：
     *  1，作为参数POJO的key
     *  2，spring mvc 会以 value 作为key，POJO类型的对象为value，存入到request中
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
        System.out.println("@ModelAttribute 注解方法执行");
        if (id != null){
            //模拟从数据库中获取对象
            User user = new User(1,"wangyan","123456","wangyan.com",13,null);
            map.put("userabc",user);
        }
    }

}
