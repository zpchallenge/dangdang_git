<%@page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>生成订单 - 当当网</title>
    <link href="../css/login.css" rel="stylesheet" type="text/css"/>
    <link href="../css/page_bottom.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<%@include file="../common/head1.jsp" %>
<div class="login_step">
    生成订单骤: 1.确认订单 >
    <span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
</div>
<div class="fill_message">

    <form name="ctl00" method="get" action="${pageContext.request.contextPath}/front/order/addOrder" id="f">
        <p>
            选择地址：
            <select id="address" name="selValue">
                <option value="0">
                    填写新地址
                </option>
                <c:forEach items="${requestScope.addressList}" var="addr" varStatus="vs">
                    <option value="${vs.count}">
                            ${addr.local}
                    </option>
                </c:forEach>
            </select>
        </p>
        <input type="hidden" name="address.id" id="addrId"/>

        <table class="tab_login">
            <tr>
                <td valign="top" class="w1">
                    收件人姓名：
                </td>
                <td>
                    <input type="text" class="text_input" name="address.name" id="addrName"/>
                    <div class="text_left" id="nameValidMsg">
                        <p>
                            请填写有效的收件人姓名
                        </p>
                    </div>
                </td>
            </tr>
            <tr>
                <td valign="top" class="w1">
                    收件人详细地址：
                </td>
                <td>
                    <input type="text" name="address.local" class="text_input" id="addrLocal"/>
                    <div class="text_left" id="addressValidMsg">
                        <p>
                            请填写有效的收件人的详细地址
                        </p>
                    </div>
                </td>
            </tr>
            <tr>
                <td valign="top" class="w1">
                    邮政编码
                </td>
                <td>
                    <input type="text" class="text_input" name="address.zipCode" id="addrZipCode"/>
                    <div class="text_left" id="codeValidMsg">
                        <p>
                            请填写有效的收件人的邮政编码
                        </p>
                    </div>
                </td>
            </tr>
            <tr>
                <td valign="top" class="w1">
                    电话
                </td>
                <td>
                    <input type="text" class="text_input" name="address.phone" id="addrPhone"/>
                    <div class="text_left" id="phoneValidMsg">
                        <p>
                            请填写有效的收件人的电话
                        </p>
                    </div>
                </td>
            </tr>
        </table>

    </form>
    <div class="login_in">

        <button class="button_1" onclick="location.href='${pageContext.request.contextPath}/front/cart/cart_list.jsp'">
            取消
        </button>
        <button class="button_1" onclick="submitForm()">下一步</button>


    </div>
</div>
<%@include file="../common/foot1.jsp" %>

<script type="text/javascript">
    function submitForm() {
        $("#f").submit();
    }

    var addresses = [
        {
            id: "",
            name: "",
            local: "",
            zipCode: "",
            phone: ""
        },

        <c:forEach items="${requestScope.addressList}" var="a">
        {
            id: "${a.id}",
            name: "${a.name}",
            local: "${a.local}",
            zipCode: "${a.zipCode}",
            phone: "${a.phone}"
        },
        </c:forEach>
    ];

    $("#address").change(function () {
        var value = $(this).val();
        var id = addresses[value].id;
        var name = addresses[value].name;
        var local = addresses[value].local;
        var zipCode = addresses[value].zipCode;
        var phone = addresses[value].phone;

        $("#addrId").val(id);
        $("#addrName").val(name);
        $("#addrLocal").val(local);
        $("#addrZipCode").val(zipCode);
        $("#addrPhone").val(phone);

        //如果value不等于0， 则input框不能修改
        if (value == 0) {
            $("input").removeAttr("readonly");
        } else {
            $("input").attr("readonly", "readonly");
        }
    });
</script>
</body>
</html>

