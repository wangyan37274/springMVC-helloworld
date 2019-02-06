<%--
  Created by IntelliJ IDEA.
  User: wangyan
  Date: 2019/1/15
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>hello springMVC</title>
  </head>
  <body>
    <!--
      测试ModelAttribute
      模拟修改操作，密码不能修改
    -->
    <form action="rd/testModelAttribute" method="post">
      <input type="hidden" name="id" value="1">
      username:<input type="text" name="username" value="wangyan">
      <br/>
      email:<input type="text" name="email" value="wangyan.com">
      <br/>
      age:<input type="text" name="age" value="12">
      <br/>
      <input type="submit" value="testModelAttribute">
    </form>
    <br/>
    <!-- 测试SessionAttributes -->
    <a href="rd/testSessionAttributes">Test SessionAttributes</a>
    <br/>
    <!-- 测试Map -->
    <a href="rd/testMap">Test Map</a>
    <br/>
    <!-- 测试modelAndView -->
    <a href="rd/testModelAndView">Test ModelAndView</a>
    <br/>

    <!-- 测试RequestParam -->
    <!-- 测试servlet api -->
    <a href="rp/testServletApi">Test ServletApi</a>
    <br/>
    <!-- 测试POJO -->
    <form action="rp/testPojo" method="post">
      username:<input type="text" name="username">
      <br/>
      password:<input type="password" name="password">
      <br/>
      email:<input type="text" name="email">
      <br/>
      age:<input type="text" name="age">
      <br/>
      city:<input type="text" name="address.city">
      <br/>
      <input type="submit" value="testPojo">
    </form>
    <br/>
    <!-- 测试cookie -->
    <a href="rp/testRequestCookie">test requestCookie</a>
    <br/>
    <!-- 测试requestHeader -->
    <a href="rp/testRequestHeader">test requestHeader</a>
    <br/>
    <!-- 测试requestParam -->
    <a href="rp/testRequestParam?username=wangyan&age=11">test requestParam</a>
    <br/>
    <!-- 测试RequestParam end -->

    <!-- 测试rest -->
    <form action="hello/testRest/1" method="post">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="test Rest Delete">
    </form>
    <br/>
    <form action="hello/testRest/1" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="test Rest Put">
    </form>
    <br/>
    <form action="hello/testRest" method="post">
      <input type="submit" value="test Rest Post">
    </form>
    <br/>
    <a href="hello/testRest/1">Test Rest Get</a>
    <br/>
    <!-- 测试rest end -->
    <a href="hello/testParamsAndHeaders?username=wangyan&age=10">Test ParamsAndHeaders</a>
    <br/>

    <a href="hello">hello springMVC</a>
    <br/>

    <a href="hello/testMethod">test post</a>
    <br/>

    <form action="hello/testMethod" method="post">
      <input type="submit" value="test post">
    </form>
  </body>
</html>
