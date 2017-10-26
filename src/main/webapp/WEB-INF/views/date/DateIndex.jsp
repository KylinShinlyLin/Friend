<%--
  Created by IntelliJ IDEA.
  User: 蛮夷麟爷
  Date: 2017-06-24
  Time: 下午21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!--图片放大缩小效果-->
    <link rel="stylesheet" type="text/css" href="css/zoom.css">

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <title>个人信息</title>
    <style type="text/css">

    </style>


</head>
<body>
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">平台</a>
                                </div>
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                    <ul class="nav navbar-nav">
                                        <li class="active">
                                            <a href="ToWorld">世界圈</a>
                                        </li>
                                        <li>
                                            <a href="ToFriend">朋友圈</a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">账号管理<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="ToMyInfo">我的信息</a>
                                                </li>
                                                <li>
                                                    <a href="#">修改密码</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                    <ul class="nav navbar-nav navbar-right">
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">其它<strong class="caret"></strong></a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="#">Action</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                        <div class="navbar-form navbar-right">
                                            <form action="LoginOut" method="post">
                                            <input type="submit" class="btn btn-danger" value="退出登陆"/>
                                            </form>
                                        </div>
                                </div>
                            </nav>






                            <!--以上都是头部-->
                            <div class="jumbotron">
                                <h1>
                                    Hello, world!
                                </h1>
                                <p>
                                    This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
                                </p>
                                <p>
                                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                                </p>
                            </div>
                            <div class="carousel slide" id="carousel-935583">
                                <ol class="carousel-indicators">
                                    <li data-slide-to="0" data-target="#carousel-935583">
                                    </li>
                                    <li data-slide-to="1" data-target="#carousel-935583">
                                    </li>
                                    <li data-slide-to="2" data-target="#carousel-935583">
                                    </li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="item next left">
                                        <img alt="" src="v3/default.jpg" />
                                        <div class="carousel-caption">
                                            <h4>
                                                First Thumbnail label
                                            </h4>
                                            <p>
                                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img alt="" src="v3/default1.jpg" />
                                        <div class="carousel-caption">
                                            <h4>
                                                Second Thumbnail label
                                            </h4>
                                            <p>
                                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="item active left">
                                        <img alt="" src="v3/default2.jpg" />
                                        <div class="carousel-caption">
                                            <h4>
                                                Third Thumbnail label
                                            </h4>
                                            <p>
                                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                            </p>
                                        </div>
                                    </div>
                                </div> <a class="left carousel-control" href="#carousel-935583" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-935583" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                            </div><img alt="140x140" src="v3/default3.jpg" class="img-thumbnail" />








                    </div>
                </div>


    <script src="js/zoom.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">

    </script>

    <!-- 代码 结束 -->

</body>
</html>
