<%--
  Created by IntelliJ IDEA.
  User: 蛮夷麟爷
  Date: 2017-06-24
  Time: 下午12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="" />
    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/icomoon.css">
    <!-- Themify Icons-->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <!-- Owl Carousel  -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div class="gtco-loader"></div>

<div id="page">


    <div class="page-inner">
        <nav class="gtco-nav" role="navigation">
            <div class="gtco-container">

                <div class="row">
                    <div class="col-sm-4 col-xs-12">
                        <div id="gtco-logo"><a href="#">莫麟 <em>.</em></a></div>
                    </div>
                    <div class="col-xs-8 text-right menu-1">
                        <ul>
                            <li class="btn-cta"><a href="#"><span>了解更多</span></a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </nav>

        <header id="gtco-header" class="gtco-cover" role="banner" style="background-image: url(images/img_4.jpg)">
            <div class="overlay"></div>
            <div class="gtco-container">
                <div class="row">
                    <div class="col-md-12 col-md-offset-0 text-left">

                        <div class="row row-mt-15em">
                            <div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
                                <!--<span class="intro-text-small">欢迎访问</span>-->
                                <h1>莫麟平台</h1><br>
                                <h3 style="color: white">在这里你能获得更多</h3>
                                <h3 class="text-danger">当前是二号服务器</h3>
                                <h3 class="text-info">${Rerroe}</h3>
                                <h3 class="text-danger">${error}</h3>
                                <h3 class="text-success">${success}</h3>
                            </div>
                            <div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                                <div class="form-wrap">
                                    <div class="tab">
                                        <ul class="tab-menu">
                                            <li class="gtco-first"><a href="#" data-tab="signup">注册</a></li>
                                            <li class="active gtco-second"><a href="#" data-tab="login">登陆</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-content-inner" data-content="signup">
                                                <form action="Regist" method="post">
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="username">注册用户名</label>
                                                            <input type="text" class="form-control" name="username">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="password">输入密码</label>
                                                            <input type="password" class="form-control" name="password">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="password2">再次输入密码</label>
                                                            <input type="password" class="form-control" id="password2" name="passwordCommit">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="password">验证码</label>
                                                            <input type="text" maxlength="4" class="form-control" name="code">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <img src="getCodeImageRe" id="imgecodeRe">
                                                            <a class="btn btn-warning" href="javascript:refreshCaptchaRe();">刷新</a>
                                                        </div>
                                                    </div><br>

                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <input type="submit" class="btn btn-info" value="提交">
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                            <div class="tab-content-inner active" data-content="login">
                                                <form action="Tologin" method="post">
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="username">用户名</label>
                                                            <input type="text" class="form-control" id="username" name="username">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="password">密码</label>
                                                            <input type="password" class="form-control" id="password" name="password">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="password">验证码</label>
                                                            <input type="text" maxlength="4" class="form-control" name="code">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <img src="getCodeImage" id="imgecode">
                                                            <a class="btn btn-warning text-success" href="javascript:refreshCaptcha();">刷新</a>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <input type="submit" class="btn btn-success" value="登陆">
                                                        </div>
                                                    </div>
                                                    <!--登陆错误-->

                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </header>





        <div id="gtco-counter" class="gtco-section">
            <div class="gtco-container">

                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
                        <h2>平台流量</h2>
                        <p>这里是平台流量</p>
                    </div>
                </div>

                <div class="row">

                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInLeft">
                        <div class="feature-center">
						<span class="icon">
							<i class="ti-settings"></i>
						</span>
                            <span class="counter js-counter" data-from="0" data-to="22070" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">今日发帖数量</span>

                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInLeft">
                        <div class="feature-center">
						<span class="icon">
							<i class="ti-face-smile"></i>
						</span>
                            <span class="counter js-counter" data-from="0" data-to="97" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">今日动态用户</span>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInLeft">
                        <div class="feature-center">
						<span class="icon">
							<i class="ti-briefcase"></i>
						</span>
                            <span class="counter js-counter" data-from="0" data-to="402" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">今日浏览量</span>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInLeft">
                        <div class="feature-center">
						<span class="icon">
							<i class="ti-time"></i>
						</span>
                            <span class="counter js-counter" data-from="0" data-to="212023" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">留言数量</span>

                        </div>
                    </div>

                </div>
            </div>
        </div>








    </div>

</div>



<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="js/jquery.countTo.js"></script>
<!-- Magnific Popup -->
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/magnific-popup-options.js"></script>
<!-- Main -->
<script src="js/main.js"></script>


<script type="text/javascript">

    //添加随机数，防止浏览器缓存导致图片加载不出
    function refreshCaptcha(){
        var ran = Math.floor(Math.random() * 100)
        document.getElementById("imgecode").src="getCodeImage?d="+ran;
    }

    //添加随机数，防止浏览器缓存导致图片加载不出
    function refreshCaptchaRe(){
        var ran = Math.floor(Math.random() * 100)
        document.getElementById("imgecodeRe").src="getCodeImageRe?d="+ran;
    }




</script>

</body>
</html>
