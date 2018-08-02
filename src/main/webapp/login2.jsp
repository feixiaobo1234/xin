<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding:0px;
        }
        body{
            background-color: white;
        }
        #top{
            width: 100%;
            height: 100px;
            background-color: white;
        }
        #top div{
            width: 243px;
            height: 81px;
            margin-left: 50px;
            margin-top: 0px;
        }
        #form{
            width: 411px;
            height: 500px;
            margin: auto;
            margin-top: 10px;
            background-color: white;
        }
        #form table{
            width: 411px;
            height: 500px;
            text-align: center;
        }
        #login{
            font-size: 20px;
            text-align: center;
            color: #F56600;
        }
        #text{
            width: 335px;
            height: 40px;
        }
        .submit{
            width: 343px;
            height: 40px;
            color: white;
            background-color: #F56600;
        }
        .a1{
            text-decoration: none;
            color: #EF5B00;
        }
        #a2{
            text-decoration: none;
            color: #999999;
        }
        #a2:hover{
            color: #EF5B00;
        }
    </style>
</head>
<body>
<div id="top">
    <div>
        <a href="index.html"><img src="img/1.png"/></a>
    </div>
</div>
<form action="miandenglu"method="post">
    <table border="0" cellspacing="0">
        <tr><td colspan="4" id="login">账户密码登录</td></tr>
        <tr><td colspan="4" height="60px"><input type="text" placeholder="邮箱/手机号码/小米ID" required="required" class="text"/></td></tr>
        <tr><td colspan="4" height="60px"><input type="password" placeholder="密码" required="required" class="text"/></td></tr>
        <tr><td colspan="4" height="60px"><input type="submit" value="登录" class="submit"/></td></tr>
        <tr><td colspan="2" height="30px"><a href="#" class="a1">手机短信登录/注册</a></td><td width="70px"><a href="zhuce.html" id="a2">立即注册</a></td><td width="123px"><a href="#" id="a2">忘记密码？</a></td></tr>
        <tr><td></td><td></td><td></td><td></td></tr>
        <tr><td></td><td></td><td></td><td></td></tr>
        <tr height="40px"><td><hr/></td><td colspan="2" style="color: #999999;">其他登录方式</td><td><hr/></td></tr>
        <tr height="40px"><td><a href="#"><img src="img/weibo.png"/></a></td><td><a href="#"><img src="img/wei.png"/></a></td><td><a href="#"><img src="img/zhi.png"/></a></td><td><a href="#"><img src="img/qq.png"/></a></td></tr>
    </table>
</form>
</body>
</html>