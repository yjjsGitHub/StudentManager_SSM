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

        //批量删除
        function del() {
            var ids = "";
            var cks = document.getElementsByName("ids");
            for (var i = 0; i < cks.length; i++) {
                if (cks[i].checked) {
                    ids += cks[i].value + "_";
                }
            }
            if (ids.length == 0) {
                alert("没有选中任何学生");
                return;
            }
            $.post("${ctx}/student/delete", {"ids": ids}, function () {
                location.reload();
            })
        }
    </script>
</head>

<center>
    <div id="contentWrap">
        <div class="pageTitle"></div>
        <div class="pageColumn">
            <h4 style="color:red;">${param.msg}</h4>
            <table>
                <thead>
                <th width="12%"><input name="ids" type="checkbox" value="" id="allChecks" onclick="ckAll()"/></th>
                <th width="22%">姓名</th>
                <th width="22%">性别</th>
                <th width="22%">住址</th>
                <th width="22%">操作&nbsp;
                    <input type="button" onclick="del()" value="删除所有"/></th>
                </thead>
                <tbody>
                <c:if test="${empty studentList}">
                    <tr>
                        <td colspan="4">没有数据！</td>
                    </tr>
                </c:if>
                <c:forEach items="${studentList}" var="student">
                    <tr>
                        <td><input type="checkbox" name="ids" value="${student.sid}"></td>
                        <td>${student.name}</td>
                        <td>${student.sex eq '0' ? '女' : '男'}</td>
                        <td>${student.address}</td>
                        <td><a href="${ctx}/student/get?sid=${student.sid}">修改</a>&nbsp;
                            <input type="button" onclick="del()" value="删除"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <nav>
        <ul class="pagination">
            当前页:${currentPage}&nbsp;总页数:${pageCount}<br>
            <a href="${ctx}/student/listByPage?cid=${klass.cid}&currentPage=1">首页</a>
            <a href="${ctx}/student/listByPage?cid=${klass.cid}&currentPage=${currentPage-1>1?currentPage-1:1}">&laquo;</a>
            <c:forEach begin="1" end="${pageCount}" varStatus="loop">
                <c:set var="active" value="${loop.index==currentPage?'active':''}"/>
                <a href="${ctx}/student/listByPage?cid=${klass.cid}&currentPage=${loop.index}">${loop.index}</a>
            </c:forEach>
            <a href="${ctx}/student/listByPage?cid=${klass.cid}&currentPage=${currentPage+1<pageCount?currentPage+1:pageCount}">&raquo;</a>
            <a href="${ctx}/student/listByPage?cid=${klass.cid}&currentPage=${pageCount}">尾页</a>
        </ul>
    </nav>
</center>
</body>
</html>
