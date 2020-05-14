package com.zp.action.back;

import com.zp.service.AdminService;
import com.zp.service.impl.AdminServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AdminAction {
    private AdminService adminService = new AdminServiceImpl ();

    private String username;
    private String password;
    private String validateCode;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String login() throws UnsupportedEncodingException {
        //获取session中存储的验证码
        HttpServletRequest request = ServletActionContext.getRequest ();
        HttpSession session = request.getSession ();
        String code = (String) session.getAttribute ("code");
        if (validateCode == null || !validateCode.equalsIgnoreCase (code)){
            message = URLEncoder.encode ("验证码错误","utf-8");
            return "validateCodeError";
        }

        //调用业务层方法
        boolean login = adminService.login (username, password);
        if (login){
            //登录成功
            session.setAttribute ("username",username);
            return "loginSuccess";
        } else {
            //登录失败
            message = URLEncoder.encode ("用户名或密码错误","utf-8");
            return "loginFail";
        }
    }

    public String logout(){
        //注销退出，清除session中的强制登录标识
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        session.removeAttribute ("username");
        return "logoutSuccess";
    }
}

