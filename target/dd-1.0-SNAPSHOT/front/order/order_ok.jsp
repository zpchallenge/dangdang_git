<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 > 2.填写送货地址 >
			<span class="red_bold">3.订单成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="../images/order_success.jpg" />
				</div>
				<h5>
					订单已经生成
				</h5>
				<h6>
					您刚刚生成的订单号是：<font color="red"><strong>${param.orderNo}</strong></font>，
					金额总计<font color="red"><strong>${param.totalPrice}</strong></font>
				</h6>

				<ul>
					<li class="nobj">
						您现在可以：还有<font color="red"><strong id="se">5</strong></font>秒,跳转到支付页面！！！
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/front/book/showMainPage">继续浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			setInterval(function () {
				var second = Number.parseInt($("#se").html());
				second = second - 1;
                if (second == 0){
                    location.href = "${pageContext.request.contextPath}/front/pay/index.jsp?orderNo=${param.orderNo}&totalPrice=${param.totalPrice}";
                }
                $("#se").html(second);
			},1000)
		</script>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

