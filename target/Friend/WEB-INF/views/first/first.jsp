<%--
  Created by IntelliJ IDEA.
  User: 蛮夷麟爷
  Date: 2017-06-24
  Time: 下午21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>欢迎新用户</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

    <!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="assets/css/demo.css" rel="stylesheet" />
</head>

<body>
<!--   背景图像   -->
<div class="image-container set-full-height" style="background-image: url('assets/img/wizard.jpg')">

    <!--  Made With Get Shit Done Kit  -->
    <a href="" class="made-with-mk">
        <div class="brand">更多</div>
        <div class="made-with">这只是一个临时的按钮还没什么<strong>卵用</strong></div>
    </a>

    <!--  核心容器   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">

                <!--      中间容器      -->
                <div class="wizard-container">

                    <div class="card wizard-card" data-color="orange" id="wizardProfile">

                        <!--这是表单开始-->
                        <form action="initialize" method="post" enctype="multipart/form-data">
                            <!--        有多种颜色可以选择 ' data-color="orange" '  with one of the next bright colors: "blue", "green", "orange", "red"          -->

                            <div class="wizard-header">
                                <h3>
                                    <b>初始化</b>你的信息<br>
                                    <small>在开始前我们需要收集您的一些信息以便后续更好的用户体验</small>
                                </h3>
                            </div>

                            <div class="wizard-navigation">
                                <ul>
                                    <li><a href="#about" data-toggle="tab">关于你</a></li>
                                    <li><a href="#account" data-toggle="tab">你的专业</a></li>
                                    <li><a href="#address" data-toggle="tab">地址</a></li>
                                </ul>

                            </div>

                            <div class="tab-content">
                                <div class="tab-pane" id="about">
                                    <div class="row">
                                        <h4 class="info-text">开始初始化你的信息</h4>
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <div class="picture-container">
                                                <div class="picture">
                                                    <img src="assets/img/default-avatar.png" class="picture-src" id="wizardPicturePreview" title=""/>
                                                    <input type="file" name="uploadfile" id="wizard-picture">
                                                </div>
                                                <h6>上传你的头像</h6>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <label><b>你的昵称</b> <small>(必须)</small></label>
                                                <input name="name" type="text" class="form-control" placeholder="...">
                                            </div>
                                            <div class="form-group">
                                                <label><b>真实姓名</b></label>
                                                <input name="realname" type="text" class="form-control" placeholder="...">
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="account">
                                    <h4 class="info-text">你的专业倾向或者你喜爱的是？</h4>
                                    <div class="row">

                                        <div class="col-sm-10 col-sm-offset-1">

                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="like" value="Design">
                                                    <div class="icon">
                                                        <i class="fa fa-pencil"></i>
                                                    </div>
                                                    <h6>艺术设计</h6>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="like" value="Code">
                                                    <div class="icon">
                                                        <i class="fa fa-terminal"></i>
                                                    </div>
                                                    <h6>软件编码</h6>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="like" value="Develop">
                                                    <div class="icon">
                                                        <i class="fa fa-laptop"></i>
                                                    </div>
                                                    <h6>工程开发</h6>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="like" value="Muics">
                                                    <div class="icon">
                                                        <i class="fa fa-music"></i>
                                                    </div>
                                                    <h6>音乐类</h6>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="like" value="Sport">
                                                    <div class="icon">
                                                        <i class="fa fa-futbol-o"></i>
                                                    </div>
                                                    <h6>运动类</h6>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-checkbox">
                                                    <input type="checkbox" name="like" value="Write">
                                                    <div class="icon">
                                                        <i class="fa fa-file-word-o"></i>
                                                    </div>
                                                    <h6>文学类</h6>
                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                </div>
                                <div class="tab-pane" id="address">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h4 class="info-text"> 你生活地区是？ </h4>
                                        </div>

                                        <div class="col-sm-5 col-sm-offset-1">
                                            <div class="form-group">
                                                <label>城市</label>
                                                <input type="text" name="city" class="form-control" placeholder="...">
                                            </div>
                                        </div>
                                        <div class="col-sm-5">
                                            <div class="form-group">
                                                <label>地区</label><br>
                                                <select name="place" class="form-control">
                                                    <option value="1"> 北京市 </option>
                                                    <option value="2"> 上海市 </option>
                                                    <option value="3"> 天津市 </option>
                                                    <option value="4"> 重庆市 </option>
                                                    <option value="5"> 广东省 </option>
                                                    <option value="6"> 湖南省 </option>
                                                    <option value="7"> 湖北省 </option>
                                                    <option value="8"> 河北省 </option>
                                                    <option value="9"> 河南省 </option>
                                                    <option value="10"> 海南省 </option>
                                                    <option value="11"> 福建省 </option>
                                                    <option value="12"> 广西省 </option>
                                                    <option value="13"> 江西省 </option>
                                                    <option value="14"> 江苏省 </option>
                                                    <option value="15">其它地区</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="wizard-footer height-wizard">
                                <div class="pull-right">
                                    <input type='button' class='btn btn-next btn-fill btn-warning btn-wd btn-sm' name='next' value='下一个' />
                                    <input type='submit' class='btn btn-finish btn-fill btn-warning btn-wd btn-sm' name='finish' value='提交' />

                                </div>

                                <div class="pull-left">
                                    <input type='button' class='btn btn-previous btn-fill btn-default btn-wd btn-sm' name='previous' value='上一个' />
                                </div>
                                <div class="clearfix"></div>
                            </div>

                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div><!-- end row -->
    </div> <!--  big container -->

    <div class="footer">
        <div class="container">
           麟爷工作室 <i class="fa fa-heart heart"></i>
        </div>
    </div>

</div>

</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="assets/js/gsdk-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="assets/js/jquery.validate.min.js"></script>

</html>
