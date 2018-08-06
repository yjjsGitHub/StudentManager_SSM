<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>学生管理系统</title>
    <link href="/images/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //setMenuHeight
            $('.menu').height($(window).height()-51-27-26);
            $('.sidebar').height($(window).height()-51-27-26);
            $('.page').height($(window).height()-51-27-26);
            $('.page iframe').width($(window).width()-15-168);

            //menu on and off
            $('.btn').click(function(){
                $('.menu').toggle();

                if($(".menu").is(":hidden")){
                    $('.page iframe').width($(window).width()-15+5);
                }else{
                    $('.page iframe').width($(window).width()-15-168);
                }
            });

            //
            $('.subMenu a[href="#"]').click(function(){
                $(this).next('ul').toggle();
                return false;
            });
        })
    </script>


</head>

<body>
<div id="wrap">
    <h2>欢迎你！管理员${email}！</h2>
    <h4>上次登陆时间：<fmt:formatDate value="${lastTime}" pattern="yyyy-MM-dd"/> </h4>
    <div id="header">

        <div class="logo fleft"></div>

        <div class="nav fleft">

            <ul>

                <div class="nav-left fleft"></div>

                <li class="first">我的面板</li>
                <li>设置</li>
                <li>模块</li>
                <li>内容</li>
                <li>用户</li>
                <li>扩展</li>
                <li>应用</li>
                <div class="nav-right fleft"></div>
            </ul>
        </div>
        <a class="logout fright" href="${ctx}/logout"> </a>
        <div class="clear"></div>
        <div class="subnav">
            <div class="subnavLeft fleft"></div>
            <div class="fleft"></div>
            <div class="subnavRight fright"></div>
        </div>
    </div><!--#header -->
    <div id="content">
        <div class="space"></div>
        <div class="menu fleft">
            <ul>
                <li class="subMenuTitle">管理模块</li>
                <li class="subMenu"><a href="#">班级模块</a>
                    <ul>
                        <li><a href="${ctx}/klassList" target="right">查看班级</a></li>
                        <li><a href="${ctx}/klass/add" target="right">添加班级</a></li>
                        <li><a href="${ctx}/klassDelete" target="right">删除班级</a></li>
                    </ul>
                </li>
                <li class="subMenu"><a href="#">学生模块</a>
                    <ul>
                        <li><a href="${ctx}/student/add" target="right">添加学生</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="sidebar fleft"><div class="btn"></div></div>
        <div class="page">
            <iframe width="100%" scrolling="auto" height="100%" frameborder="false" allowtransparency="true" style="border: medium none;" src="${ctx}/klassList" id="rightMain" name="right"></iframe>
        </div>
    </div><!--#content -->
    <div class="clear"></div>
    <div id="footer"></div><!--#footer -->
</div><!--#wrap -->
</body>
</html>
