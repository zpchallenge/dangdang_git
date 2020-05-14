package com.zp.action.back;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getValidateCode.png")
public class ValidateCodeAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha (200, 100);
        // 获取验证码
        String code = lineCaptcha.getCode ();
//        System.out.println (code);

        //存储到Session中
        HttpSession session = req.getSession ();
        session.setAttribute ("code",code);

        //把验证码图片放到响应的字节流中
        lineCaptcha.write (resp.getOutputStream ());
    }
}
