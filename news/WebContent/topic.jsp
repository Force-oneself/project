<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is topic</title>
</head>
<body>
	<table border="1" style="text-align: center;">
		<caption>主题新闻</caption>

		<tr>
			<th>编号</th>
			<th>主题名</th>
			<th>修改时间</th>
			<th>是否修改</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.page.list}" var="topic">
		<tr>
			<td>${topic.id }</td>
			<td>${topic.topicName }</td>
			<td>${topic.createDate }</td>
			<td>${topic.flag }</td>
			<td>
				<a href="TopicEditFace?id=${topic.id}&page=${page.currentPage}">修改</a> 
				<a href="TopicDelete?id=${topic.id}&page=${page.currentPage}"
				onclick="if(confirm('确定要删除' +'${topic.topicName }吗?')==false) return false;">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<a href="TopicServlet?page=1">第一页</a> 
		<c:if test="${page.currentPage != 1 }">
			<a href="TopicServlet?page=${page.currentPage - 1}">上一页</a>
		</c:if>
		第${page.currentPage}/${page.pages}页
		<c:if test="${page.currentPage != page.pages }">
			<a href="TopicServlet?page=${page.currentPage + 1}">下一页</a>
		</c:if>
		<a href="TopicServlet?page=${page.pages}">最后一页</a>
	</div>
</body>
</html>