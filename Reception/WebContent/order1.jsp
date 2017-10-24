<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="com.neusoft.entity.*" %>
    <%@ page import="com.neusoft.services.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<title></title>
	<link rel="stylesheet" href="css/order.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
	<script type="text/javascript" src="js/order1.js" ></script>
	<script type="text/javascript">

		
	</script>
	
</head>
<body class="login">
	<div class="backimg">
		<div class="topdiv"><a href="homepage.jsp">首页</a></div>
		<form action="orderInfoServlet.do" method="post">
		<div class="logink">
			<div class="div1">
				<span>订单剩余支付时间:</span><span id="timed">24:09:43</span>
			</div>
			<div class="div2">
				<span>您的订单编号为:</span><span><%=UUID.randomUUID().toString().substring(0,8) %></span>
				
				<input type="hidden" name="oid" value="<%=UUID.randomUUID().toString().substring(0,8) %>"/>
			</div>
			<div class="div3">
				<p>收货信息</p>
				<input type="text" name="name" id="name" placeholder="请输入收货人姓名" /></br>
				<input type="text" name="phone" id="phone" placeholder="请输入收货人联系方式" /></br>
				
			   	   <select id="mySelect" value="options[selectedIndex].value" name="sel2" style="width: 200px; height: 30px;margin-left:15px;" onchange="selectProv(this)">
						<option>请选择省份</option>
					  </select>
				   <select id="mySelect3"  name="sel3" style="width: 200px; height: 30px;" onchange="selectCity(this)">
						<option>请选择城市</option>
				   </select>
				   <select id="mySelect4" name="sel4" style="width: 200px; height: 30px;">
						<option>请选择地区</option>
				  </select>
				  
				  <input name="detailInfo" type="text" id="inputPassword" placeholder="请输入详细地址" >
			</div>
			<div class="div4">
				<p>订单商品信息</p>
				<table cellpadding="0" cellspacing="0" border="1" width="800px">
				<thead>
					<tr>
						<td>商品编号</td>
						<td>商品名称</td>
						<td>商品价格</td>
						<td>数量</td>
						<td>小计</td>
					</tr>
				</thead>
				<tbody>
		<c:forEach items="${shoppingBag.map}" var="me" >  
          <tr>  
          <td>${me.key}</td>  
           <td>${me.value.product.pname}</td>  
           <td>${me.value.product.price}￥</td> 
          <td>${me.value.quantity}</td> 
           <td>${me.value.price}￥</td> 
           </tr>
           </c:forEach>
				</tbody>
				</table>
			</div>
			<div class="div5">
				<p>支付方式:&nbsp;&nbsp;总金额<span style="color:green;">${shoppingBag.price }￥</span></p>
				请选择支付方式:
				<input type="radio" value="1" name="payStyle" />支付宝支付&nbsp;&nbsp;
				<input type="radio" value="2" name="payStyle" />微信支付&nbsp;&nbsp;
				<input type="radio" value="3" name="payStyle" />网银支付
			</div>
			<div class="div6">
				<p>备注信息</p>
				<textarea cols="30" rows="5" name="info"></textarea>
			</div>
			<input type="submit" name="sub" value="确认提交"/>
		</div>
		</form>
	</div>
	

</body>
</html>