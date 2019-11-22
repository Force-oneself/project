<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="何永泉" />
<meta name="keywords" content="信息，学生，管理，系统，学生信息管理系统" />
<meta name="description" content="13亿人都在用的APP" />
<link rel="icon" href=".//images/title.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js"></script>
<script src=></script>
</head>
<body onload="changeImg();">
	<div class="login" align="center">
		<div class="login_title" style="margin-top: 20px;">
			<div class="title" style="font-size: 20px; color: #333333;">系统登录</div>
			<div class=""></div>
		</div>
		<!-- 系统登录模块 -->
		<div class="login_form" style="margin-top: 50px;">
			<form action="login" method="post">
				<!-- 账号输入 -->
				<div class="area userArea">
					<div id="clear"
						onclick="getElementById('username').value='';
                    	getElementById('clear').style.visibility='hidden';">
					</div>
					<input type="text" value="${username }" id="username"
						name="username" placeholder="账号/支持手机账号登录"
						style="margin-left: -15px;" onkeydown="clearHidden();"
						onkeyup="clearHidden();">
				</div>
				<!-- 密码输入 -->
				<div class="area passwordArea">
					<input type="password" value="${password }" id="password"
						name="password" placeholder="密码">
				</div>
				<!-- 错误提示 -->
				<div class="errorArea">${error }</div>
				<!-- 提交按钮 -->
				<div>
					<input class="area sublmitArea" type="submit" value="登录"
						style="background-color: #09d723d4; color: white; margin-left: 0; cursor: pointer;">
				</div>
			</form>
		</div>
	</div>
	<!-- 背景图片 -->
	<div class="backgroundImg"
		style="width: 100%; height: 100%; top: 0; left: 0; position: absolute; z-index: 0;">
		<img src="" id="bg_img"
			style="transition-duration: 1s; width: 100%; height: 100%; top: 0; position: absolute; z-index: -1; opacity: 1;">
	</div>
</body>
</html>