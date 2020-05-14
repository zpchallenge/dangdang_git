<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/front/book/showMainPage'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${requestScope.oneName}</strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<c:if test="${requestScope.levels == 1}">
										<div class=second_fenlei style="color: red">
											&middot;全部&nbsp;(${requestScope.totalCount})
										</div>
									</c:if>
									<c:if test="${requestScope.levels != 1}">
										<div class=second_fenlei>
											&middot;全部&nbsp;(${requestScope.totalCount})
										</div>
									</c:if>
								</div>
							</li>
							<div class="clear"></div>
						<c:forEach items="${requestScope.categoryList}" var="c">
							<c:if test="${requestScope.levels == 1}">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath}/front/book/showBookByCategory?id=${c.id}">${c.name}&nbsp;(${c.count})</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
							<!--2级分类结束-->
							</c:if>

							<c:if test="${requestScope.levels == 2 && c.id == id}">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei3>
										<a style="color: red" href="${pageContext.request.contextPath}/front/book/showBookByCategory?id=${c.id}">${c.name}&nbsp;(${c.count})</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
							<!--2级分类结束-->
							</c:if>
							<c:if test="${requestScope.levels == 2 && c.id != id}">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath}/front/book/showBookByCategory?id=${c.id}">${c.name}&nbsp;(${c.count})</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
							<!--2级分类结束-->
							</c:if>
						</c:forEach>
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->

							<div class='list_r_title_text3a'>
								<c:if test="${requestScope.currentPage - 1 <= 0}">
								        <img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
								</c:if>
                                <c:if test="${requestScope.currentPage - 1 > 0}">
								    <a name=link_page_next href="${pageContext.request.contextPath}/front/book/showBookByCategory?id=${requestScope.id}&pageNum=${requestScope.currentPage - 1}&pageSize=4">
									    <img src='${pageContext.request.contextPath}/front/images/page_up.gif' />
								    </a>
                                </c:if>
							</div>

							<div class='list_r_title_text3b'>
								第${requestScope.currentPage}页/共${requestScope.totalPage}页
							</div>

							<div class='list_r_title_text3a'>
                                <c:if test="${requestScope.currentPage + 1 > requestScope.totalPage}">
                                    <img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />
                                </c:if>
                                <c:if test="${requestScope.currentPage + 1 <= requestScope.totalPage}">
								    <a name=link_page_next href="${pageContext.request.contextPath}/front/book/showBookByCategory?id=${requestScope.id}&pageNum=${requestScope.currentPage + 1}&pageSize=4">
									    <img src='${pageContext.request.contextPath}/front/images/page_down.gif' />
								    </a>
                                </c:if>
							</div>



							<!--分页导航结束-->
						</div>
					</div>

					<!--商品条目开始-->

						<div class="list_r_line"></div>
					<c:forEach items="${requestScope.books}" var="b">
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${pageContext.request.contextPath}/front/book/showOneBookById?bookId=${b.id}' target='_blank'>
										<img height="100px" src="${pageContext.request.contextPath}/back/img/${b.cover}" />
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${pageContext.request.contextPath}/front/book/showOneBookById?bookId=${b.id}' target='_blank'>${b.name}</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${b.author}</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${b.press}</a>
								</h4>
								<h4>
									出版时间：<fmt:formatDate value="${b.pressDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
								</h4>
								<h5>
									${b.contentAbstract}
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${b.price}</span>
									<span class="red">￥${b.dprice}</span>
									节省：￥${b.price - b.dprice}
								</h6>
								<span class="list_r_list_button">
								<a href="#"> 
									<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' />
								</a>
								<span id="cartinfo"></span>
								</span>
							</div>
						<div class="clear"></div>
					</c:forEach>
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
