package com.zp.action.front;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.extra.mail.MailUtil;
import com.zp.entity.Users;
import com.zp.service.UsersService;
import com.zp.service.impl.UsersServiceImpl;
import com.zp.util.UUIDUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class UserAction {
    private UsersService usersService = new UsersServiceImpl ();

    private Users u;
    private String password1;
    private String validateCode;
    private String errorMsg;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String register() throws UnsupportedEncodingException {
        //获取session中的验证码
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        String code = (String) session.getAttribute ("code");
        if (validateCode == null || !validateCode.equalsIgnoreCase (code)){
            errorMsg = URLEncoder.encode ("验证码错误","utf-8");
            return "validateCodeError";
        }

        if (password1 == null || !password1.equals (u.getPassword ())){
            errorMsg = URLEncoder.encode ("两次密码不一致","utf-8");
            return "twoPasswordDiff";
        }

        u.setSalt (RandomUtil.randomString (6));
        String password = u.getPassword ();
        HMac md5 = new HMac (HmacAlgorithm.HmacMD5, u.getSalt ().getBytes ());
        u.setPassword (md5.digestHex (password));
        u.setStatus ("冻结");
        u.setCreateDate (new Date ());
        u.setId (UUIDUtil.getUUID ());
        u.setCode (RandomUtil.randomString (6));
        //调用业务层方法
        boolean register = usersService.register (u);
        if (register){
            //发送激活码，使用hutool上的工具类
            MailUtil.send (u.getEmail (), "当当注册激活码", "您的当当注册激活码：<font size='12px' color='red'>"+u.getCode ()+"</font>",true );
            email = u.getEmail ();
            return "registerSuccess";
        } else {
            errorMsg = URLEncoder.encode ("邮箱已存在","utf-8");
            return "registerFail";
        }

    }

    //获取激活码，激活账户  通过email和激活码
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String changeUserStatus() throws UnsupportedEncodingException {
        Users users = usersService.selectUserByEmail (email);
        if (users.getCode ().equals (code)){
            //把注册成功的用户放进session
            HttpSession session = ServletActionContext.getRequest ().getSession ();
            session.setAttribute ("u",users);
            usersService.updateStatus ("正常",users.getId ());
            return "changeUserStatusSuccess";
        } else {
            email = email;
            errorMsg = "激活码错误";
            return "changeUserStatusFail";
        }
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() throws UnsupportedEncodingException {
        Users user = usersService.selectUserByEmail (email);
        if (user == null){
            errorMsg = URLEncoder.encode ("邮箱不存在","utf-8");
            return "emailNotExist";
        }
        if (user.getStatus ().equals ("冻结")){
            errorMsg = URLEncoder.encode ("账户未激活","utf-8");
            return "userNotUser";
        }

        boolean login = usersService.login (email, password);
        if (login){
            HttpSession session = ServletActionContext.getRequest ().getSession ();
            session.setAttribute ("u",user);
            return "loginSuccess";
        } else {
            errorMsg = URLEncoder.encode ("密码错误","utf-8");
            return "loginFail";
        }

    }


    //退出
    public String logout(){
        //移除session中的登陆标识
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        session.removeAttribute ("u");
        return "logoutSuccess";
    }

}
