<%--
  Created by IntelliJ IDEA.
  User: 刘仁华
  Date: 2019/3/9
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/calendar/WdatePicker.js"></script>
<body>
<fm:form method="post" modelAttribute="user" action="">
    <fm:errors path="userCode"/><br/>
 用户编码:<fm:input path="userCode"></fm:input><br/>
    <fm:errors path="userName"/><br/>
 用户名称:<fm:input path="userName"></fm:input><br/>
    <fm:errors path="gender"/><br/>
 用户性别:<fm:input path="gender"></fm:input><br/>
    <fm:errors path="userPassword"/><br/>
 用户密码:<fm:input path="userPassword"></fm:input><br/>
    <fm:errors path="birthday"/><br/>
 用户生日:<fm:input path="birthday" Class="Wdate" id="birthday" name="birthday"
                readonly="readonly" onclick="WdatePicker();"/><br/>
    <fm:errors path="address"/><br/>
    用户地址:<fm:input path="address"></fm:input><br/>
    <fm:errors path="phone"/><br/>
    联系电话:<fm:input path="phone"></fm:input><br/>
    <fm:errors path="userRole"/><br/>
    用户角色:
    <fm:radiobutton path="userRole" value="1"/>系统管理员
    <fm:radiobutton path="userRole" value="2"/>经理
    <fm:radiobutton path="userRole" value="3"/>普通用户<br/>
    <input type="submit" value="保存">
</fm:form>
</body>
</html>
