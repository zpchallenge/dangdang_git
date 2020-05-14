<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<c:forEach items="${requestScope.newBooks}" var="b">
		<div class="second_d_wai">
			<div class="img">
				<a href="#" target='_blank'>
					<img src="${pageContext.request.contextPath}/back/img/${b.cover}" border=0 />
				</a>
			</div>
			<div class="shuming">
				<a href="#" target="_blank">${b.name}</a><a href="#" target="_blank"></a>
			</div>
			<div class="price">
				定价：￥${b.price}
			</div>
			<div class="price">
				当当价：￥${b.dprice}
			</div>
			<div class="price">
				销量：<font color="red">${b.sale}</font>
			</div>
		</div>
		<div class="book_c_xy_long"></div>
	</c:forEach>

</div>
<div class="clear"></div>