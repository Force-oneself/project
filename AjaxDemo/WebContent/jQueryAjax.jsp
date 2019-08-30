<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function jqueryAjax() {
		var $mobile = $("#mobile").val();
		$.ajax({
			url: "AjaxServlet",
			请求方式:"post",
			data: "mobile=" + $mobile,
			success: function(result, testStatus) {
				if(result == "true") {
					alert("存在");
				} else {
					alert("不存在");
				}
			},
			error: function(xhr, errorMessage, e) {
				alert("error");
			}
		})
	}
	
	function postAjax() {
		var $mobile = $("#mobile").val();
		$.post(
			"AjaxServlet",
			"mobile=" + $mobile,
			function(result, testStatus) {
				if(result == "true") {
					alert("存在");
				} else {
					alert("不存在");
				}
			},
			"text"
		);
	}
	
	function getAjax() {
		var $mobile = $("#mobile").val();
		$.get(
			"AjaxServlet",
			"mobile=" + $mobile,
			function(result, testStatus) {
				if(result == "true") {
					alert("存在");
				} else {
					alert("不存在");
				}
			}
		);
	}
	
	function loadAjax() {
		var $mobile = $("#mobile").val();
		$("#tip").load(
			"AjaxServlet",
			"mobile=" + $mobile
		);
	}
	
	function getJsonAjax() {
		var $mobile = $("#mobile").val();
		$.getJSON(
			"AjaxServlet",
			{"mobile": $mobile},
			function(result) {
				if(result.msg == "true") {
					alert("存在");
				} else {
					alert("不存在");
				}
			}
		);
	}
</script>
<body>
	手机：<input type="text" id="mobile" /><br>
	<input type="button" value="提交" onclick="getJsonAjax()" />
	<span id="tip"></span>
</body>
</html>