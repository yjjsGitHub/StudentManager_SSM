<%--
  Created by IntelliJ IDEA.
  User: pqr
  Date: 2018/7/13
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/taglib.jsp" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<center>
    <h2>添加学生</h2>
    <div style="color:red;">${param.msg}</div>
    <form action="save" method="post">
        <table>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>班级</td>
                <td>
                    <select name="cid">
                        <c:forEach items="${klassList}" var="klass">
                            <option value="${klass.cid}">${klass.cname}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <select name="sex">
                        <option value="0">女</option>
                        <option value="1">男</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>住址</td>
                <td><textarea name="address" id="" cols="30" rows="10"></textarea></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="确认">
                    <input type="button" value="返回首页" onclick="javascript:location.href='${ctx}/klassList';">
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
