<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
        <link type="text/css" rel="stylesheet" href="../css/register.css"/>
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<h2 align="center" style="color: red;">${param.errorMsg}</h2>
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/front/user/register" id="f" >
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					用户名不存在
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="u.email" id="email"  type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="userEmail"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="u.nickname"  type="text" id="nickname" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>

								<span id="userNickname"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="u.password" type="password" id="password" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="userPassword"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="password1" class="text_input"/>

							<div class="text_left" id="repeatPassValidMsg">
								<span id="userPassword1"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/getValidateCode.png" />
							<input name="validateCode" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的五个字母。</span>
									<a href="javascript:void(0)" onclick="changeImg()" id="change" >看不清楚？换个图片</a>
									<br/>
									<span id="userCode"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			function changeImg() {
				$("#imgVcode").prop("src", "${pageContext.request.contextPath}/getValidateCode.png?time="+new Date().getTime());
			}
			function checkEmail() {
				var email = $("#email").val();
				var userEmail = $("#userEmail");
				var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
				if (pattern.test(email)){
					userEmail.prop("class","ok_prompt");
					userEmail.html("邮箱格式正确");
					return true;
				} else {
					userEmail.prop("class","error_prompt");
					userEmail.html("邮箱格式错误");
					return false;
				}
			}

			function checkNickname(){
				var nickname = $("#nickname").val();
				var userNickname = $("#userNickname");
				var pattern = /^[\u4E00-\u9FA5A-Za-z0-9]{2,20}$/;
				if (pattern.test(nickname)){
					userNickname.prop("class","ok_prompt");
					userNickname.html("昵称符合规范");
					return true;
				} else {
					userNickname.prop("class","error_prompt");
					userNickname.html("昵称不符合规范");
					return false;
				}
			}

			function checkPassword(){
				var password = $("#password").val();
				var userPassword = $("#userPassword");
				var pattern = /^[0-9A-Za-z]{6,20}$/;
				if (pattern.test(password)){
					userPassword.prop("class","ok_prompt");
					userPassword.html("密码符合规范");
					return true;
				} else {
					userPassword.prop("class","error_prompt");
					userPassword.html("密码不符合规范");
					return false;
				}
			}

			function checkPassword1(){
				var password1 = $("#password1").val();
				var password = $("#password").val();
				var userPassword1 = $("#userPassword1");
				var pattern = /^[0-9A-Za-z]{6,20}$/;
				if (pattern.test(password1)){
					if (password == password1){
						userPassword1.prop("class","ok_prompt");
						userPassword1.html("密码符合规范");
						return true;
					} else {
						userPassword1.prop("class","error_prompt");
						userPassword1.html("两次密码输入不一致");
						return false;
					}
				} else {
					userPassword1.prop("class","error_prompt");
					userPassword1.html("密码不符合规范");
					return false;
				}
			}

			function checkCode(){
			    var txtVerifyCode = $("#txtVerifyCode").val();
				var userCode = $("#userCode");
				var pattern = /^[0-9A-Za-z]{5}$/;
				if (pattern.test(txtVerifyCode)){
                    userCode.prop("class", "ok_prompt");
                    userCode.html("验证码格式正确");
                    return true;
                } else {
                    userCode.prop("class", "error_prompt");
                    userCode.html("验证码格式不正确");
                    return false;
                }
            }

			$("#email").blur(checkEmail);
			$("#nickname").blur(checkNickname);
			$("#password").blur(checkPassword);
			$("#password1").blur(checkPassword1);
			$("#txtVerifyCode").blur(checkCode);

			$("#f").submit(function () {
               var c1 = checkEmail();
               var c2 = checkNickname();
               var c3 = checkPassword();
               var c4 = checkPassword1();
               var c5 = checkCode();
               return c1 && c2 && c3 && c4 && c5;
            });
		</script>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

