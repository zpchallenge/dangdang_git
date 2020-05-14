<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="../css/book_detail.css"/>
		<link href="../css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<h1>
				丛书名：${requestScope.book.name}
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath}/back/img/${requestScope.book.cover}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${requestScope.book.author}</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${requestScope.book.press}</td>
			</tr>
			<tr>
				<td>出版时间： <fmt:formatDate value="${requestScope.book.pressDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
				<td>字数：${requestScope.book.wordNum}</td>
			</tr>
			<tr>
				<td>版次：${requestScope.book.edition}</td>
				<td>页数：${requestScope.book.pageNum}</td>
			</tr>
			<tr>
				<td>印刷时间：<fmt:formatDate value="${requestScope.book.printDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
				<td>开本：${requestScope.book.sizes}</td>
			</tr>
			<tr>
				<td>印次：${requestScope.book.impression}</td>
				<td>纸张：${requestScope.book.paper}</td>
			</tr>
			<tr>
				<td>ISBN：${requestScope.book.isbn}</td>
				<td>包装：${requestScope.book.pack}</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${requestScope.book.price}&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${requestScope.book.dprice}</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${requestScope.book.price - requestScope.book.dprice}</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/front/cart/addCart?id=${requestScope.book.id}">
						<img src='../images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>&nbsp;&nbsp;${requestScope.book.editorRecommend}</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>&nbsp;&nbsp;${requestScope.book.contentAbstract}</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>&nbsp;&nbsp;${requestScope.book.authorAbstract}</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>&nbsp;&nbsp;${requestScope.book.director}</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>&nbsp;&nbsp;${requestScope.book.mediaCommentary}</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="../images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
