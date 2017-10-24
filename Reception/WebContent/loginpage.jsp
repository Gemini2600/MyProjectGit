<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/loginpage.css" />
</head>
<body class="login">
	<div class="backimg">
		<div class="logink">
			<div class="logink1">
				<span id="dspan">登录</span>
				<span id="mspan"><a href="registerpage.jsp" >免费注册</a></span>
			</div>
			<form action="loginServlet.do" method="get">
			<h5>账号</h5>
			<div class="logink2"><input class="but" type="text" placeholder="请输入用户名" name="loginname"/></div>
			<h5>密码<span id="wspan"><a href="#">忘记密码？</a></span></h5>
			<div class="logink3"><input class="but" type="password" placeholder="请输入密码" name="password"/></div>
			<div class="logink4"><input class="cbut" type="checkbox"/><span id="qspan">七天内免登录</span></div>
			<div class="logink5"><input class="but1" type="submit" name="sub" value="登    录"/></div>
			</form>>
		</div>
	</div>

</body>
</html>