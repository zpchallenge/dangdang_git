<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<%--<script type="text/javascript">--%>
			<%--$(function () {--%>
				<%--var p = 0;--%>
				<%--var total = 0;--%>
				<%--$(".yprice").each(function (i, obj1) {--%>
					<%--console.log(i, obj1);--%>
					<%--var dprices = $(".dprice");--%>
					<%--var price = Number.parseFloat($(this).html());--%>
					<%--var dprice = Number.parseFloat($(dprices[i]).html());--%>
					<%--console.log(price, dprice);--%>
					<%--var counts = $(".count");--%>
					<%--var count = Number.parseInt($(counts[i]).html());--%>
					<%--p += (price - dprice) * count;--%>
					<%--total += dprice*count;--%>
				<%--});--%>
				<%--$("#total_economy").html(p);--%>
				<%--$("#total_account").html(total);--%>

			<%--});--%>
		<%--</script>--%>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />
		</div>
		
		<div id="div_no_choice">
			<div class="choice_title"></div>
			<div class="no_select">
				您还没有挑选商品[<a href=''> 继续挑选商品&gt;&gt;</a>]
			</div>
		</div>
		
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					<c:forEach items="${sessionScope.cart.itemMap}" var="cartMap">
					<!-- 购物列表开始 -->
						<tr class='td_no_bord'>
						<td style='display: none'>
							${cartMap.key}
						</td>
						<td class="buy_td_6">
							<span class="objhide">
								<img src="" />
							</span>
						</td>
						<td style="padding-left: 100px">
							<a href="${pageContext.request.contextPath}/front/book/showOneBookById?bookId=${cartMap.key}">${cartMap.value.book.name}</a>
						</td>
						<td class="buy_td_5">
							￥<span class="c_gray yprice">${cartMap.value.book.price}</span>
						</td>
						<td class="buy_td_4">
							&nbsp;&nbsp;
							￥<span class="dprice">${cartMap.value.book.dprice}</span>
						</td>
						<td class="buy_td_1">
							&nbsp;&nbsp;<span class="count">${cartMap.value.count}</span>
						</td>

						<td >
							<form action="${pageContext.request.contextPath}/front/cart/changeCount">
								<input type="hidden" name="id" value="${cartMap.key}"/>
								<input class="del_num" type="number" name="count" size="3" maxlength="4" />
								<a href="javascript:void(0)" onclick="toSubmit(this)">变更</a>
							</form>
						</td>
						<td>
							<a href="${pageContext.request.contextPath}/front/cart/deleteById?id=${cartMap.key}">删除</a>
						</td>
					</tr>
					</c:forEach>
				</table>
                <script type="text/javascript">
                    function toSubmit(obj) {
                        $(obj).parent("form").submit();
                    }
                </script>
				<div class="choice_balance">
					<div class="select_merch">
						<a href="${pageContext.request.contextPath}/front/book/showMainPage"> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${sessionScope.cart.priceSave}</span> </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${sessionScope.cart.totalPrice}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='../order/order_info.jsp' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--页尾开始 -->
		<div style="position:absolute;bottom: 10px;width:100%;">
			<%@include file="../common/foot.jsp"%>
		</div>
		<!--页尾结束 -->
	</body>
</html>



