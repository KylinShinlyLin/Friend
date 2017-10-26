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
    <title>首页</title>
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
                                    <div class="navbar-form navbar-left" >
                                        <a href="ToDate" class="btn btn-info">去约会</a>
                                    </div>

                                    <div class="navbar-form navbar-left" >
                                        <a href="http://119.29.209.127:8080/seckill2/list" class="btn btn-warning">去秒杀</a>
                                    </div>

                                    <!--<div class="navbar-form navbar-left" >
                                        <a id="modal-813663" href="#modal-container-813663" role="button" class="btn btn-success" data-toggle="modal">发朋友圈</a>
                                    </div>-->


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


                            <!--遮罩层
                            <div class="modal fade" id="modal-container-813663" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">

                                        <form action="PublishMessage" method="post">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                <h4 class="modal-title text-warning" id="myModalLabel">
                                                    发送朋友圈
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <h3>您要留言的内容</h3>
                                                <input type="text" name="word" class="form-control" placeholder="请输入内容......." >
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button> <button type="submit"  class="btn btn-success">提交</button>
                                            </div>
                                        </form>

                                    </div>

                                </div>
                            </div>-->




















                            <br><br><br><br>
                            <div class="media well">

                                <div class="media-body">
                                    <h4 class="media-heading">
                                        发布于****时间
                                    </h4>
                                    <div class="media">
                                        <a href="#" class="pull-left"><img src="${userDetail.imagUrl}" class="media-object" width="40px" height="40px" alt='' /></a>
                                        <div class="media-body">
                                            <h4 class="media-heading">
                                                用户名：${userDetail.name}
                                            </h4>
                                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                        </div>
                                        <p class="text-info">点击进入可以留言</p>
                                    </div>
                                </div>
                            </div>











                        </div>
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
