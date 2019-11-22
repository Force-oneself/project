<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<%
	 // 权限验证
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
		return;
	}
%>
</head>
<body>
	登录成功
</body>
</html>