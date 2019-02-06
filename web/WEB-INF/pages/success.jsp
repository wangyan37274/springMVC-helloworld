<%--
  Created by IntelliJ IDEA.
  User: wangyan
  Date: 2019/1/15
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>hello springMVC</title>
  </head>
  <body>
    <h4>Success Page</h4>
    time:${requestScope.time}
    <br/>
    names:${requestScope.names}
    <br/>
    request user:${requestScope.user}
    <br/>
    session user:${sessionScope.user}
    <br/>
    request user:${requestScope.school}
    <br/>
    session user:${sessionScope.school}
    <br/>
    user user:${requestScope.usercba}
    <br/>
    model user:${requestScope.userabc}
    <br/>
    <fmt:message key="i18n.username"></fmt:message>
    <br/>
    <fmt:message key="i18n.password"></fmt:message>
  </body>
</html>
