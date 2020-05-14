<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/back/css/btn.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/btn.css"/>
	</head>
	<body style="background-color: #f0f9fd;">
		<div align=center style="font-size:25px">用户管理</div><hr/>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px">
			<tr bgcolor='lightblue' align='center'>
				<td>Id</td>
				<td>昵称</td>
				<td>邮箱</td>
				<td>状态</td>
				<td>激活码</td>
				<td>操作</td>
			</tr>
			<c:forEach var="u" items="${requestScope.users}">
				<tr align='center'>
					<td>${u.id}</td>
					<td>${u.nickname}</td>
					<td>${u.email}</td>
					<td>${u.status}</td>
					<td>${u.code}</td>
					<td>
						<div class="button" onclick="location.href='${pageContext.request.contextPath}/user/updateStatus?id=${u.id}&status=${u.status}' ">修改 &raquo;</div>
					</td>
				</tr>
			</c:forEach>

		</table>
		<div align=center style="margin-top:50px;">
			总共<span style="color: red;">${requestScope.total}</span>个用户，共 <span style="color: red">${requestScope.totalPage}</span>页
		</div>
		<div align=center>
			<c:forEach var="i" begin="1" end="${requestScope.totalPage}" step="1">
				<button onclick="location.href = '${pageContext.request.contextPath}/user/showAll?pageNum=${i}&pageSize=3'" style="width: 50px;background-color: #00b68a;color: black;font-size: 15px">${i}</button>
			</c:forEach>
		</div>
	</body>
</html>



