<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">    
<head>    
    <title>百度地图API显示多个标注点带提示的代码</title>    
    <!--css-->    
    <style type="text/css">
        body, html, #allmap
        {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
        }
        #l-map
        {
            height: 100%;
            width: 78%;
            float: left;
            border-right: 2px solid #bcbcbc;
        }
        #r-result
        {
            height: 100%;
            width: 20%;
            float: left;
        }
    </style>
    <!--javascript-->    
    <script src="http://www.w3school.com.cn/jquery/jquery.js" type="text/javascript"></script>    
</head> 

<body>
            <div id="allmap"> 
                   
            </div>
            <script type="text/javascript">
                var websocket = new WebSocket('ws://localhost:8080/webSocketServer');
                websocket.onopen = function (evnt) {
                    console.log('ws clint:open websocket');
                    //发送消息
                    var msg = '这个是来自浏览器的消息';
                    console.log('ws clint:send msg:'+msg);
                    websocket.send(msg);
                };

                websocket.onmessage = function (evnt) {
                    console.log('ws client:get message ');
                    var bp0 = evnt.data.split(",")[0];
                    var bp1 = evnt.data.split(",")[1];
                    makers[0].setPosition(new window.BMap.Point(bp0, bp1));
                  /*  makers[0].getPosition().lng = bp0;
                    makers[0].getPosition().lat = bp1;*/
                };

                websocket.onerror = function (evnt) {
                    console.log('ws client:error '+evnt)
                };

                websocket.onclose = function (evnt) {
                    console.log('ws clent:close ')
                }


                var makers = new Array();
                var tempPoint = null;
                var markerArr = [    
                    { id: "1", title: "名称：123", point: "113.264531,23.157003", address: "123456", tel: "12306" },

                ];    
     

                var map; //Map实例    
                function map_init() {    
                    map = new BMap.Map("allmap");
                   
                    //第1步：设置地图中心点
                    var point = new BMap.Point(113.312213, 23.147267);    
                    //第2步：初始化地图,设置中心点坐标和地图级别。    
                    map.centerAndZoom(point, 1);
                    //第3步：启用滚轮放大缩小    
                    map.enableScrollWheelZoom(true);    
                    //第4步：向地图中添加缩放控件    
                    var ctrlNav = new window.BMap.NavigationControl({    
                        anchor: BMAP_ANCHOR_TOP_LEFT,    
                        type: BMAP_NAVIGATION_CONTROL_LARGE    
                    });    
                    map.addControl(ctrlNav);    
                    //第5步：向地图中添加缩略图控件    
                    var ctrlOve = new window.BMap.OverviewMapControl({    
                        anchor: BMAP_ANCHOR_BOTTOM_RIGHT,    
                        isOpen: 1   
                    });    
                    map.addControl(ctrlOve);    
     
                    //第6步：向地图中添加比例尺控件    
                    var ctrlSca = new window.BMap.ScaleControl({    
                        anchor: BMAP_ANCHOR_BOTTOM_LEFT    
                    });    
                    map.addControl(ctrlSca);    

                    //点击事件
                    map.addEventListener("click", showInfo);

                    function showInfo(e) {//鼠标点击显示经纬度
                        //alert(e.point.lng + ", " + e.point.lat);
                        alert("websocket触发");


                        if(confirm("是否发送websocket？")==true){
                            websocket.send("浏览器发送过来的消息");
                        }
                        tempPoint = e;
                    }
     
                    //第7步：绘制点      
                    for (var i = 0; i < markerArr.length; i++) {
                       
                        var p0 = markerArr[i].point.split(",")[0];    
                        var p1 = markerArr[i].point.split(",")[1];    
                        var maker = addMarker(new window.BMap.Point(p0, p1), i);    
                        makers[i] = maker;
                        addInfoWindow(maker, markerArr[i], i);
                    }    
                }    
     
                var makers = new Array();
                // 添加标注    
                function addMarker(point, index) {
                    var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png",    
                        new BMap.Size(23, 25), {    
                            offset: new BMap.Size(10, 25),    
                            imageOffset: new BMap.Size(0, 0 - index * 25)    
                        });    
                    var marker = new BMap.Marker(point, { icon: myIcon });
                    marker.enableDragging();
                    map.addOverlay(marker);    
                    return marker;    
                }    

                function getActPoint(id){
                    var marketpoint =makers[id].getPosition();
                    alert(tempPoint.point.lng+"  ,"+tempPoint.point.lat);
                }


                

     
                // 添加信息窗口    
                function addInfoWindow(marker, poi,e) {    
                    //pop弹窗标题    
                    var title = '<p style="font-weight:bold;color:#CE5521;font-size:14px">' + poi.title + '</p>';    
                    //pop弹窗信息    
                    var html = [];    
                    html.push('<table cellspacing="0" style="table-layout:fixed;width:100%;font:12px arial,simsun,sans-serif"><tbody>');    
                    html.push('<tr>');    
                    html.push('<td style="vertical-align:top;line-height:16px;width:38px;white-space:nowrap;word-break:keep-all">地址:</td>');    
                    html.push('<td style="vertical-align:top;line-height:16px">' + poi.address + ' </td>');
                    
                    html.push('</tr>');    
                    html.push('</tbody></table>');  
                    html.push('<div>');
                    html.push('<button onclick=\"getActPoint('+poi.id+');\">显示当前位置</button>');
                          
                    html.push('</div>');     
                    var infoWindow = new BMap.InfoWindow(html.join("*"), { title: title, width: 200 });    
     
                    var openInfoWinFun = function () {    
                        marker.openInfoWindow(infoWindow);    
                    };    
                    marker.addEventListener("click", openInfoWinFun);
                    marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画    
                    return openInfoWinFun;    
                }    
     
                //异步调用百度js    
                function map_load() {    
                    var load = document.createElement("script");    
                    load.src = "http://api.map.baidu.com/api?v=1.4&callback=map_init";    
                    document.body.appendChild(load);    
                }    
                window.onload = map_load;    
            </script>    
</body>    
</html>