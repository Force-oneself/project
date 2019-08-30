<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function getCommit() {
		var mobile = document.getElementById("mobile").value;
		xmlHttpRequest = new XMLHttpRequest();
		xmlHttpRequest.onreadystatechange = callBack;
		xmlHttpRequest.open("get", "AjaxServlet?mobile=" + mobile, true);
		xmlHttpRequest.send(null);
	}


	function postCommit() {
		var mobile = document.getElementById("mobile").value;
		xmlHttpRequest = new XMLHttpRequest();
		xmlHttpRequest.onreadystatechange = callBack;
		xmlHttpRequest.open("post", "AjaxServlet", true);
		// xmlHttpRequest.setRequestHeader("Content-Type", "multipart/form-data");
		xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttpRequest.send("mobile=" + mobile);
	}
	
	function callBack() {
		if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			var data = xmlHttpRequest.responseText;
			if(data == "true") {
				alert("存在");
			} else {
				alert("不存在")
			}
		}
	}
</script>
<body>
	手机：<input type="text" id="mobile" /><br>
	<input type="button" value="提交" onclick="getCommit()" />
</body>
</html>