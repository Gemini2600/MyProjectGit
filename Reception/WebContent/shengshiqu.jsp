<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@page import="com.neusoft.entity.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.neusoft.dao.impl.AddressDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市区</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
<script type="text/javascript">
   
</script>
</head>
<body>
	 <%
     AddressDaoImpl ad = new AddressDaoImpl();
     List<Address> list = ad.getSheng();
     request.setAttribute("list",list);
   %>
     省:<select onchange="shi(this);">
       <c:forEach items="${list}" var="address">
          <option>${address.name}</option>
       </c:forEach>
     </select>
     <br>
     市：<select id="shi" onchange="qu(this);">
     
     </select>
     <br>
     区：<select id="qu">
     
     </select>
</body>
</html>