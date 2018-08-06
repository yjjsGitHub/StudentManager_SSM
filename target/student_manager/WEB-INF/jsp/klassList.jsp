<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/taglib.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="${ctx}/images/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${ctx}/jQuery/jquery-3.1.1.min.js"></script>
    <style type="text/css">
        body {
            background: #FFF
        }
    </style>
    <script>
        //复选框全选
        function ckAll() {
            var flag = document.getElementById("allChecks").checked;
            var cks = document.getElementsByName("ids");
            for (var i = 0; i < cks.length; i++) {
                cks[i].checked = flag;
            }

        }
    </script>
</head>

<body>
<div id="contentWrap">
    <div class="pageTitle"></div>
    <div class="pageColumn">
        <h4 style="color:red;">${param.msg}</h4>
        <table>
            <thead>
            <th width="10%"><input name="" type="checkbox" value="" id="allChecks" onclick="ckAll()"/></th>
            <th width="30%">班级</th>
            <th width="30%">备注</th>
            <th width="30%">操作</th>
            </thead>
            <tbody>
            <c:if test="${empty classList}">
                <tr>
                    <td colspan="4">没有数据！</td>
                </tr>
            </c:if>
            <c:forEach items="${classList}" var="klass">
                <tr>
                    <td><input type="checkbox" name="ids" value="${klass.cid}"></td>
                    <td>${klass.cname}</td>
                    <td>${klass.note}</td>
                    <td><a href="${ctx}/student/listByPage?cid=${klass.cid}&currentPage=${1}">学生列表</a>&nbsp;<a
                            href="${ctx}/klass/get?cid=${klass.cid}">修改</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
