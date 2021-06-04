<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Ajax应用</title>
</head>
<script type="text/javascript">
    var xmlHttp;

    //创建XMLHttpRequest对象
    function createHttpRequest() {
        if (window.ActiveXObject) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } else if (window.XMLHttpRequest) {
            xmlHttp = new XMLHttpRequest();
        }
    }

    function beginCheck() {
        //得到用户填写的学号
        var xh = document.all.xh.value;
        //如果为空
        if (xh == "") {
            alert("对不起，请输入注册学号！");
            return;
        }
        createHttpRequest();
        //将状态触发器绑定到一个函数
        xmlHttp.onreadystatechange = processor;
        //通过get方法向指定的URL即Servlet对应URL建立服务器的调用
        xmlHttp.open("get", "CheckUser?xh=" + xh);
        //发送请求
        xmlHttp.send(null);
    }

    //处理状态改变函数
    function processor() {
        var responseContext;
        //如果响应完成
        if (xmlHttp.readyState == 4) {
            //如果返回成功
            if (xmlHttp.status == 200) {
                //取得响应内容
                responseContext = xmlHttp.responseText;
                //如果注册名检查有效
                if (responseContext.indexOf("true") != -1) {
                    alert("恭喜你，该学号有效！");
                } else {
                    alert("对不起，该学号已经被注册！");
                }
            }
        }
    }
</script>
<body>
<form action="">
    学号：
    <!-- 当输入框改变是执行beginCheck()函数 -->
    <input type="text" name="xh" onchange="beginCheck()"/>
    口令：
    <input type="password" name="kl"/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
