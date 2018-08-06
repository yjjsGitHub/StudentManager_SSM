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
    <title>更新班级信息</title>
</head>
<body>
<center>
    <h2>更新班级信息</h2>
    <h4 style="color:red;">${param.msg}</h4>
    <form action="update" method="post">
        <table>
            <tr>
                <input type="hidden" name="cid" value="${klass.cid}"/>
                <td>班级名称</td>
                <td><input type="text" name="cname" value="${klass.cname}" ></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><textarea name="note" id="" cols="30" rows="10" >${klass.note}</textarea></td>
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
