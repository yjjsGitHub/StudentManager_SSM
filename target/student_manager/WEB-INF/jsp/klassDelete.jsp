<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="images/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/jQuery/jquery-3.1.1.min.js"></script>
    <style type="text/css">
        body {
            background:#FFF
        }
    </style>
    <script>
        //复选框全选
        function ckAll() {
            var flag=document.getElementById("allChecks").checked;
            var cks=document.getElementsByName("ids");
            for(var i=0;i<cks.length;i++){
                cks[i].checked=flag;
            }
        }
        //批量删除
        function del() {
            var ids = "";
            var cks=document.getElementsByName("ids");
            for(var i=0;i<cks.length;i++){
                if(cks[i].checked) {
                    ids+=cks[i].value+"_";
                }
            }
            if (ids.length==0) {
                alert("没有选中任何班级");
                return;
            }
            $.post("${ctx}/klass/delete",{"ids":ids},function () {
                location.reload();
            })
        }
    </script>
</head>

<body>
<div id="contentWrap">
    <div class="pageTitle"></div>
    <div class="pageColumn">
        <table>
            <thead>
            <th width="10%"><input name="" type="checkbox" value="" onclick="ckAll()" id="allChecks"/></th>
            <th width="30%">班级</th>
            <th width="30%">备注</th>
            <th width="30%">
                <input type="button" onclick="del()" value="删除" />
            </th>
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
                    <td><input type="button" onclick="del()" value="删除" /></th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div></div>
</body>
</html>
