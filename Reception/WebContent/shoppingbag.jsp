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
 <title>购物显示页面</title>  
    <script type="text/javascript">  
        function deleteItem(id){  
        var  b = window.confirm("确定要删除吗？");  
           if(b){  
                window.location.href="${pageContext.request.contextPath}/deleteItemServlet.do?id="+id;
           }  
        }  
        function clearcart(){  
        var  b = window.confirm("确定要清空您的购物袋吗？");  
           if(b){  
                window.location.href="${pageContext.request.contextPath}/clearCartServlet.do";             
           }  
        }  
    function changequantity(input,id,oldvalue){  
           //得到修改的数量  
          var quantity = input.value;  
            
          //判断是否是正整数  
          if(quantity<0 || quantity!=parseInt(quantity)){  
                 alert("请输入正整数！！");  
                 input.value=oldvalue;  
                 return;  
          }  
           var  b = window.confirm("确定要将数量修改为："+quantity);  
           if(b){  
                window.location.href="${pageContext.request.contextPath}/changeQuantityServlet.do?id="+id+"&quantity="+quantity;             
           }  
         
       }  
      function pay(){
    	  var  b = window.confirm("确定去结算吗？");  
          if(b){ 
        	  if(${consumer.loginname!=null}){
              		window.location.href="${pageContext.request.contextPath}/order.jsp";             
        	  }else{
        		  window.location.href="${pageContext.request.contextPath}/loginpage.jsp";             
        	  }
       	}  
      }
    </script> 
  </head>  
    
  <body style="text-align:center"> 
   
  <h1> 您的购物车</h1>  
    <h2>您购买了如下商品</h2>  
    <c:if test="${empty shoppingBag.map}">  
 <font color="red">您的购物袋还是空的哦！！</font><br/>      
    您可以  
    <a href="${pageContext.request.contextPath}/homeServlet.do">点击此处进入购买页面</a>
	</c:if>
 	<c:if test="${!empty shoppingBag.map}">
      <table  width="80%" cellpadding="0" cellspacing="0" border="1">  
        <tr>  
           <td>商品编号</td>  
           <td>商品名称</td>  
           <td>单价</td>  
           <td>数量</td>  
           <td>小计</td>  
           <td>操作</td>     
        </tr>  
        
        <c:forEach items="${shoppingBag.map}" var="me" >  
          <tr>  
          <td>${me.key}</td>  
           <td>${me.value.product.pname}</td>  
           <td>${me.value.product.price}￥</td>  
           <td>  
                              修改数量	
          <input type="text" name="quantity" value="${me.value.quantity}" onchange="changequantity(this,${me.key},${me.value.quantity})"/>  
           
           </td>  
           <td>${me.value.price}￥</td>  
             
           <td>  
                <a href="javascript:deleteItem(${me.key })" >删除</a>  
                  <!--<a href="javascript:void(0)" onclick="deleteItem(${me.key })">删除</a>-->  
               <!--<a href="${pageContext.request.contextPath}/servlet/DeleteItemServlet?id=${me.key}">删除</a>-->  
             
           </td>     
            
          </tr>  
          
        </c:forEach>  
        <tr>  
            <td colspan="3">总价</td>  
            <td colspan="1">${shoppingBag.price }￥</td>  
            <td>  
                  <!--<a href="${pageContext.request.contextPath}/servlet/ClearCartServlet">清空购物车</a>-->  
                <a href="javascript:clearcart()">清空购物袋</a>  
            </td>  
             <td> <a href="javascript:pay()">去结算</a></td>  
        </tr>  
  
      </table> 
      <c:choose>
  		<c:when test="${consumer.loginname==null}">
  			<a href="homeServlet.do">返回继续购物</a>
  		</c:when>
  		<c:otherwise>
  			<a href="loginHomeServlet.do">返回继续购物</a>
  		</c:otherwise>	
		</c:choose> 
        

</c:if>

</body>
</html> 