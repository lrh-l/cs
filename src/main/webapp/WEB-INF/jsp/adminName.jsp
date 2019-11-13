
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script src="../../statics/js/jquery-1.8.3.min.js"></script>
</head>
<style>
    *{
        margin: 0px;
        padding: 0px;
        list-style: none;
    }
    .wap{
        height: 80px;
        width: 100%;
        line-height: 50px;
    }
    .wap-le{
        font-size: 14px;
        color: #5a5156;
        padding: 1px;
        margin-right: 40px;
    }
    #adminName{
        text-align: center;
        height: 33px;
        width: 282px;
        border: 1px solid gainsboro;
    }
    .search_btn{
        margin-right: 13px;
        padding: 0px;
        height: 33px;
        width: 60px;
        float: right;
        border: 1px solid  #069dd5;
        background-color: #069dd5;
        border-radius: 0px 10px 10px 0px;

    }
    #spanName{
        font-size: 11px;
        color: red;
        height:15px;
        width: 200px;
        display: block;
        margin-left: 144px;
        margin-top: -8px;
        line-height: 15px;
        padding: 1px;
        letter-spacing:2px
    }
    .wap-div-input{
        width: 355px;
        height: 40px;
        display: inline-block;
    }
    .wap-ul{
        width: 220px;
        height: 180px;
        border:  1px solid red;
        margin-left: 150px;
        margin-top: -17px;
    }
    .wap-ul-ll{
        font-size:12px;
        color: #ff9000 ;
        padding: 0px;
        width: 100%;
        height: 30px;
        letter-spacing:2px;
        line-height: 30px;

    }
</style>
<body>

<form action="/itAccountInfo/queryAdminName.html" method="get" id="queryName">
    <div class="wap">
        <label class="wap-le">账号管理员姓名</label>
        <div class="wap-div-input">
            <input type="text" id="adminName" name="adminName"  value="${user.get(0).userName}"/>
            <input type="submit"  id="button" class="search_btn"   value="搜索" />
        </div>
        <span id="spanName" ></span>
        <ul class="wap-ul">
          <%--  <c:forEach var="user" items="${user}" varStatus="">
                <li class="wap-ul-ll">${user.userName}</li>
            </c:forEach>--%>
        </ul>
    </div>
</form>
<form id="saveAdminName" name="userForm" method="post"  enctype="multipart/form-data"
      action="/user/addsave.html">
    <c:forEach var="user" items="${user}">

    </c:forEach>
    <input type="hidden" name="method" value="add">
    <!--div的class 为error是验证错误，ok是验证成功-->
    <div>
        <label for="userCode">用户编码：</label>
        <input type="text" readonly="readonly" name="userCode" id="userCode"   value="${user.get(0).userCode}">
        <!-- 放置提示信息 -->
        <font color="red"></font>
    </div>
    <div>
        <label for="userName">用户名称：</label>
        <input type="text"  readonly ="readonly" name="userName" id="userName" value="${user.get(0).userName}">
        <font color="red"></font>
    </div>
    <div>
        <label for="userPassword">用户密码：</label>
        <input type="password" name="userPassword" id="userPassword" value="">
        <font color="red"></font>
    </div>
    <div>
        <label for="ruserPassword">确认密码：</label>
        <input type="password" name="ruserPassword" id="ruserPassword" value="">
        <font color="red"></font>
    </div>
    <div>
        <label >用户性别：</label>
        <select name="gender" id="gender">
            <option value="1" selected="selected">男</option>
            <option value="2">女</option>
        </select>
    </div>

    <div>
        <label for="phone">用户电话：</label>
        <input type="text" name="phone" id="phone" value="">
        <font color="red"></font>
    </div>
    <div>
        <label for="address">用户地址：</label>
        <input name="address" id="address"  value="">
    </div>
    <div>
        <label >用户角色：</label>
        <!-- 列出所有的角色分类 -->
        <%--<select name="userRole" id="userRole"></select>--%>
        <select name="userRole" id="userRole">
            <option value="1">系统管理员</option>
            <option value="2">经理</option>
            <option value="3" selected="selected">普通员工</option>
        </select>
        <font color="red"></font>
    </div>

    <div class="providerAddBtn">
        <input type="button" name="add" id="add" value="保存" >
        <input type="button" id="back" name="back" value="返回" >
    </div>
</form>
</body>
<script>

    $(document).ready(function(){
        //提交表单,调用验证函数
        $("#queryName").submit(function(){
            var flag = true;
            if (!checkFname()) flag = false;
            return flag;
        });
        //绑定失去焦点事件
        $("#adminName").blur(checkFname);
    });

    //验证名字
    function checkFname() {
        var $fname = $("#adminName");
        var $divID = $("#spanName");
        $divID.html("");
        if ($fname.val() == ""  ) {
            $divID.html("名字不能为空");
            return false;
        }else if($fname.val() =="请输入姓名/编号进行搜索"){
            $divID.html("名字不能为空");
            return false;
        }
        return true;
    }


    $("#adminName").focus(function() {
        var adnimName = $(this).val()
        if (adnimName == '请输入姓名/编号进行搜索') {
            $(this).val("");
        }
    });


</script>
</html>
