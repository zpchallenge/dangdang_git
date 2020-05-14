<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<c:forEach items="${requestScope.editorBooks}" var="b">
			<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath}/front/book/showOneBookById?bookId=${b.id}' target='_blank'>
					<img height="100px" src="${pageContext.request.contextPath}/back/img/${b.cover}" width=70 border=0 />
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath}/front/book/showOneBookById?bookId=${b.id}' target='_blank' title='输赢'>${b.name}</a>
				</h3>
				<h4>
					作者：${b.author} 著
					<br />
					出版社：${b.press}&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<fmt:formatDate value="${b.pressDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
				</h4>
				<h5>
					${b.contentAbstract}
				</h5>
				<h6>
					定价：￥${b.price}&nbsp;&nbsp;
					当当价：￥${b.dprice}
					销量：<font color="red">${b.sale}</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
		
	</div>
</div>
