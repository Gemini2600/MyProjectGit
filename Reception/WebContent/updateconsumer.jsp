<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<style>
		.form-control{
			width:180px;
		}
		.topdiv{
			width: 100%;
			height: 43px;
			background-color: #070707;
		}
		.topdiv a{
			font-size: 16px;
		    float: right;
		    margin-right: 450px;
		    line-height: 43px;
		    color: whitesmoke;
		}
		.topdiv a:hover{
			color: #CCCCCC;
		}
		.b_div{
			
			width:300px;
			margin-left:100px;
		}
		p{
			margin: 0 0 10px;
			font-size: 16px;
			font-weight: bold;
		}
		</style>
		
</head>
<body>
<div class="topdiv"><a href="loginHomeServlet.do">首页</a></div>
<div class="b_div">
<p>个人信息管理</p>
<form action="updateConsumer.do" method="post">
  <div class="form-group has-success">
  <label class="control-label" for="inputSuccess1" >用户名</label>
  <input type="text" class="form-control" id="username" name="user" aria-describedby="helpBlock2" value="${consumer.loginname==null?'':consumer.loginname }">

</div>
 <div class="form-group has-success">
  <label class="control-label" for="inputSuccess1">请输入旧密码</label>
  <input type="password" class="form-control" id="inputSuccess1" aria-describedby="helpBlock2">
  <span id="helpBlock2" class="help-block" style="color:#F00"></span>
</div>
 <div class="form-group has-success">
  <label class="control-label" for="inputSuccess1">请输入新密码</label>
  <input type="password" class="form-control" id="inputSuccess2" name="psw" aria-describedby="helpBlock2" onfocus="myFunction()">
  <span id="helpBlock2" class="help-block" ></span>
</div>
<button type="submit" class="btn btn-success">确定</button>  
<button type="reset" class="btn btn-success">取消</button>                       
</form>
</div>
<script type="text/javascript">
	function myFunction()
	{
		/* alert("1"); */
		console.log($("#username").val());
		$.ajax({
			url:"http://localhost:8080/Reception/updateConsumer2.do?uName="+$("#username").val()+"&password="+$("#inputSuccess1").val(),
			type:"post",
			async:true,
			success:function(data)
			{
				//console.log("success data:"+JSON.stringify(data));
				console.log(typeof(data));
				if(data.match("密码错误"))
					{
						$("#helpBlock2").html("原密码错误");					
					}
				else if(data.match("密码正确"))
					{
						$("#helpBlock2").html("");		
					}
			}
		})
	}
	

</script>
</body>
</html>