<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>管理员登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wrap">
    <div id="header"> </div>
    <div id="content-wrap">
        <div class="space"> </div>
        <form action="login" method="post">
            <div class="content">
                <div class="field"><label>账　户：</label><input class="username" name="email" type="text" /></div>
                <div class="field"><label>密　码：</label><input class="password" name="password" type="password" /><br /></div>
                <div><h4 style="color:red;">${param.msg}</h4></div>
                <div class="btn">
                    <input name="" type="submit" class="login-btn" value="登录" />
                    <input name="" type="reset" class="login-btn" value="重置" />
                </div>
            </div>
        </form>
    </div>
    <div id="footer"> </div>
</div>
</body>
</html>
