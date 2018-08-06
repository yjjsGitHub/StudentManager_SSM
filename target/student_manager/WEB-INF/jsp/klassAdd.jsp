<%--
  Created by IntelliJ IDEA.
  User: pqr
  Date: 2018/7/13
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/taglib.jsp"%>
<html>
<head>
    <title>添加班级</title>
</head>
<body>
<center>
    <h2>添加班级</h2>
    <h4 style="color:red;">${param.msg}</h4>
    <form action="save" method="post">
        <table>
            <tr>
                <td>班级名称</td>
                <td><input type="text" name="cname"></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><textarea name="note" id="" cols="30" rows="10"></textarea></td>
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
