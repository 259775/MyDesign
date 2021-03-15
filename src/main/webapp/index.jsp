<%--
  Created by IntelliJ IDEA.
  User: 哇哈哈
  Date: 2021/3/9
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>精品课程网站</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="./view/index.css">
    <script defer src="./view/index.js" type="text/javascript" language="JavaScript" charset="UTF-8"></script>
</head>
<body>
<div class="bodySty">
    <div class="headSty">
        <div>
            <a href="
            <c:choose>
            <c:when test="${sessionScope.userid == null}">./login.jsp</c:when>
            <c:otherwise>./view/student.html</c:otherwise>
            </c:choose>
            ">
            <c:choose>
                <c:when test="${sessionScope.userid == null}">登录</c:when>
                <c:otherwise>${sessionScope.user.sName}</c:otherwise>
            </c:choose></a>
            <a href="#">我的课程</a>
            <a href="#">试题</a>
            <a name="top"></a>
        </div>
    </div>
    <img src="img/titleIcon.jpeg">

    <div id="titleOne">
        精品课程网站
    </div>
    <div id="titleTwo">
        PS-B-0104工作室
    </div>

    <div class="carousel" style="height: 500px;width: 5000px;margin-top: 100px;position: absolute;left: 0px;">
        <a class="carouselOption" name="001"><img src="img/p3.jpg"></a>
        <a class="carouselOption" name="002"><img src="img/p2.jpg"></a>
        <a class="carouselOption" name="003"><img src="img/p1.jpg"></a>
        <a class="carouselOption" name="004"><img src="img/p4.jpg"></a>
        <a class="carouselOption" name="001"><img src="img/p3.jpg"></a>
    </div>
    <div class="carouselIcon">
        <div></div>
        <div></div>
        <div></div>
        <div></div>
    </div>

    <div class="videoList">
        <div>
            <a href="#" title="2021--前端JavaScript零基础-->精通">
                <img src="img/jsIcon.jpg">
                <span>2021--前端JavaScript零基础-->精通</span>
            </a>
        </div>
        <div>
            <a href="#" title="2021--后端Java从入门到入土">
                <img src="img/javaIcon.jpg">
                <span>2021--后端Java从入门到入土</span>
            </a>
        </div>
        <div>
            <a href="#" title="2021--前端HTML零基础-->精通">
                <img src="img/htmlIcon.jpg">
                <span>2021--前端HTML零基础-->精通</span>
            </a>
        </div>
        <div>
            <a href="#" title="2021--前端CSS零基础-->精通">
                <img src="img/cssIcon.jpg">
                <span>2021--前端CSS零基础-->精通</span>
            </a>
        </div>
        <div>
            <a href="#" title="ps板绘商业插画/插画设计/插画/板绘/手绘/CG插画/设计">
                <img src="img/drawIcon.jfif">
                <span>ps板绘商业插画/插画设计/插画/板绘/手绘/CG插画/设计</span>
            </a>
        </div>
        <div>
            <a href="#" title="3D建模/3DMAX MAYA ZBrush零基础建模/角色/场景/次世代/游戏建模">
                <img src="img/gameIcon.jfif">
                <span>3D建模/3DMAX MAYA ZBrush零基础建模/角色/场景/次世代/游戏...</span>
            </a>
        </div>
    </div>

    <div class="endSty">
        <div>
            <a href="#">
                <img src="img/indexIcon.png"><br>
                <span>首页</span>
            </a>
        </div>
        <div>
            <a href="#">
                <img src="img/mycourseIcon.png"><br>
                <span>我的课程</span>
            </a>
        </div>
        <div>
            <a href="#">
                <img src="img/mesIcon.png"><br>
                <span>我</span>
            </a>
        </div>

    </div>
</div>

<div class="suspension">
    <div>
        <a href="
        <c:choose>
            <c:when test="${sessionScope.userid == null}">./login.jsp</c:when>
            <c:otherwise>./view/student.html</c:otherwise>
        </c:choose>
        ">
            个人
        </a>
    </div>
    <div>
        <a href="">
            选项
        </a>
    </div>
    <div>
        <a href="#top">
            置顶
        </a>
    </div>
</div>

</body>
</html>
