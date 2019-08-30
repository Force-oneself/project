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
    // 返回单个json对象
	function testJson() {
		$.getJSON(
				"JsonServlet",
				{"name": "peter", "age": "18"},
				function(result) {
					// js需要通过eval（） 函数将返回值转为一个js能够识别的json对象
					var jsonStudent = eval(result.stu1);
					alert(jsonStudent.name + "---" + jsonStudent.age);
				}
			);
	}
    
	function testJsonList() {
		$.getJSON(
				"JsonServlet",
				{"name": "peter", "age": "18"},
				function(result) {
					var json = eval(result);
					// 遍历json数组
					$.each(json, function(i, element){
						alert(this.name + "---" + this.age);
					});
				}
			);
	}
</script>
<body>
	<input type="button" value="测试json" onclick="testJsonList()" />
</body>
</html>