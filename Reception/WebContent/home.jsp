<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/home.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
	<script type="text/javascript">
	  function jia(pid) {
			$.ajax({
				type:"get",
				url:"shoppingBagServlet.do?ype=" + pid,
			})
		} 
	</script>

	</head>
	<body>
		<div class="div1">
	
			<div class="div1_1">
				<div class="div1_1_1">
					<div class="div1_1_1_1">
						<ul>
							<li><a href="homeServlet.do">首页</a></li>
							<li><a href="loginpage.jsp" target="_blank">登录</a></li>
							<li><a href="registerpage.jsp" target="_blank">注册</a></li>
						</ul>
					</div>
					<div class="div1_1_1_2">
						<img src="img/shop.png" />
						<a href="shoppingbag.jsp" target="_blank" style="color: white;">购物袋&nbsp;-&nbsp;0件商品</a>
						
					</div>
				</div>
			</div>
			<div class="div1_2">
				<div class="div1_2_1">
					
				</div>
				<form  action="searchServlet.do" method="post">
				<div class="div1_2_2">
					<input id="input1" type="text" name="search" placeholder="例如：alexanderwang"/>
					<button id="but1" type="submit"><img src="img/search.png"/></button>
				</div>
				</form>
			</div>
			<form action="homeServlet.do" method="get">
			<div class="div1_3">
				<div class="div1_3_00"><a>女士</a></div>
				<div class="div1_3_0"><a>男士</a></div>
				<div class="div1_3_0"></div>
				<div class="div1_3_0"><a href="#">最新资讯</a></div>
				<div class="div1_3_01"><a href="#">关于我们</a></div>
			</div>
			</form>
			<div class="div1_4">
			
				<c:forEach items="${products.datas}" var="pmd" varStatus="status">
				<div class="div1_4_11">
						<div class="div1_4_11_1">
							<a href="#"><img src="${pmd.pic}" /></a>   
						</div>
						<div class="div1_4_11_2">
							<a href="#"><input type="text" name="pname" value="${pmd.pname}"/></a>
						</div>
						<div class="div1_4_11_3">
							<input type="text" name="price" value="${pmd.price}"/>
						</div>
						<div class="div1_4_11_4">
					
						<button id="btn" value="${pmd.id}" onclick="jia(${pmd.id})">加入购物车</button>
						
						</div>
				</div>
				</c:forEach>

			</div>
			<div class="div1_5">
	共${products.totalcount}条记录${products.pageNo}/${products.totalPageSize}页&nbsp;
		
	<c:if test="${products.pageNo>0}">
	<a href="homeServlet.do?reqType=2&pageNo=1&pageSize=4">首页</a>&nbsp;
	</c:if>
	
    <a href="homeServlet.do?reqType=2&pageNo=${products.pageNo==1?products.pageNo:products.pageNo-1}&pageSize=4">上一页</a>&nbsp;
	
	<a href="homeServlet.do?reqType=2&pageNo=${products.pageNo==products.totalPageSize?products.pageNo:products.pageNo+1}&pageSize=4">下一页</a>&nbsp;
	
	<a href="homeServlet.do?reqType=2&pageNo=${products.totalPageSize}&pageSize=4">尾页</a>
	
	第<select onchange="self.location.href=options[selectedIndex].value">
  		
  		<c:forEach begin="0" end="${products.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${products.pageNo==i+1 }">
  			<option value="homeServlet.do?reqType=2&pageNo=${i+1} }&pageSize=4" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="homeServlet.do?reqType=2&pageNo=${i+1}&pageSize=4" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
		</select>页
			</div>
		</div>
		
	</body>
</html>
