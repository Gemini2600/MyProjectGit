
//创建AJAX异步对象，即XMLHttpRequest
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//定位文本框，同时提供焦点失去事件
	document.getElementById("usernameID").onblur = function(){
	//获取文本框中输入的值
	var username = this.value;
	//如果用户没有填内容
	if(username.length == 0){
		//提示 
		document.getElementById("resID").innerHTML = "用户名必填";
	}else{
		//对汉字进行UTF-8(U8)的编码
		username = encodeURI(username);
		
		//NO1)
		var method = "GET";
		var url = "registerPageServlet.do";
		xmlhttp.open(method,url);
		//NO2)
		xmlhttp.send(null);
		
		//--------------------------------------------------------等待
		//NO3)
		xmlhttp.onreadystatechange = function(){
			if(xmlhttp.readyState == 4){
				if(xmlhttp.status == 200){
					//NO5)
					var tip =xmlhttp.responseText;
					//NO6)
					document.getElementById("resID").innerHTML = tip;
				}
			}
		}
	}
}
