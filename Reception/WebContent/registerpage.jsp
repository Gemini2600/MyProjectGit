<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/registerpage.css" />
		<!-- <script type="text/javascript" src="js/registerpage.js" ></script> -->
	</head>
	<body class="register">
	<div class="backimg">
		<div class="topdiv"><a href="homeServlet.do">首页</a></div>
		<form action="registerPageServlet.do" method="post">
		<div class="registerk">
			<div class="registerk1">
				<span id="dspan">注册</span>
				<span id="mspan">已有兰花花账号？<a href="loginpage.jsp" >登录</a></span>
			</div>
			<h5>账号</h5>
				
				<div class="registerk2">
					<input class="but" type="text" id="usernameID" name="loginname" maxlength="10" />
					<p><span id="resID"></span></p>
				</div>
				
			<h5>用户昵称</h5>
			<div class="registerk3"><input class="but" type="text" name="nickname" required="true" missingMessage="昵称必须填写"/></div>
			<h5>密码</h5>
			<div class="registerk2">
				<input class="but" type="password" name="password" id="psw" required="true" missingMessage="密码必须填写"/>
				</div>
			<h5>确认密码</h5>
			<div class="registerk3">
				<input class="but" type="password" name="surepassword" id="surepsw" required="true" missingMessage="密码必须填写" onkeyup="validate()"/>
				<span id="sureId"></span>
			</div>
			<div class="registerk5"><input class="but1" type="submit" name="sub" value="注    册"/></div>
		</div>
		</form>
	</div>
	<script type="text/javascript">
		//创建AJAX异步对象，即XMLHttpRequest
		function createAJAX(){
			var ajax = null;
			try{
				ajax = new ActiveXObject("microsoft.xmlhttp");
			}catch(e1){
				try{
					ajax = new XMLHttpRequest();
				}catch(e2){
					alert("你的浏览器不支持ajax，请更换浏览器");
				}
			}
			return ajax;
		}
		

	</script>
	
	
	<script type="text/javascript">
		//定位文本框，同时提供焦点失去事件
		document.getElementById("usernameID").onblur = function(){
			//获取文本框中输入的值
			var username = this.value;
			//如果用户没有填内容
			if(username.length == 0 || username.length<8){
				//提示 
				document.getElementById("resID").innerHTML = "用户名不少于八位";
			}else{
				//对汉字进行UTF-8(U8)的编码
				username = encodeURI(username);
				//NO1)
				var ajax = createAJAX();
				//NO2)
				var method = "GET";
				var url = "registerVerifyServlet.do";
				ajax.open(method,url);
				//NO3)
				ajax.send(null);
				
				//--------------------------------------------------------等待
				
				//NO4)
				ajax.onreadystatechange = function(){
					if(ajax.readyState == 4){
						if(ajax.status == 200){
							//NO5)
							var tip = ajax.responseText;
							//NO6)
							document.getElementById("resID").innerHTML = tip;
						}
					}
				}
			}
		}
		//验证两次输入密码是否一致
		function validate() {
			var firstpsw=document.getElementById("psw").value;
			var secondpsw = document.getElementById("surepsw").value;
			//判断两次密码是否一致
			if(firstpsw==secondpsw){
				document.getElementById("sureId").innerHTML="<font color='green'>√</font>";
				document.getElementById("submit").disabled = false;
			}else{
				document.getElementById("sureId").innerHTML="<font color='red'>×</font>";
                document.getElementById("submit").disabled = true;
			}
		}
	</script>
</body>
</html>