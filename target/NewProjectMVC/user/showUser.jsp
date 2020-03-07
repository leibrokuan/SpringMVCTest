<%@ page import="java.util.List" %>
<%@ page import="pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leikuan
  Date: 2019/10/21
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>首页</li>
        <li>管理信息</li>
        <li>查看用户信息</li>
    </ul>
</div>

<div class="rightinfo">
    <table class="tablelist">
        <thead>
        <tr>

            <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>出生年月</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lu}" var="u">
            <tr>
            <td>${u.uid}</td>
            <td>${u.uname}</td>
            <td>${u.pwd}</td>
            <td>${u.sex}</td>
            <td>${u.age}</td>
            <td>${u.birth}</td>
            </tr>
        </c:forEach>
        <%--<%--%>
            <%--List<User> lu =(ArrayList<User>) request.getAttribute("lu");--%>
            <%--for (User u:lu){--%>
        <%--%>--%>
        <%--<tr>--%>
            <%--<td><%=u.getUid()%></td>--%>
            <%--<td><%=u.getUname()%></td>--%>
            <%--<td><%=u.getPwd()%></td>--%>
            <%--<td><%=u.getSex()%></td>--%>
            <%--<td><%=u.getAge()%></td>--%>
            <%--<td><%=u.getBirth()%></td>--%>
        <%--</tr>--%>
        <%--<% }%>--%>
        </tbody>
    </table>
    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>

</body>
</html>
