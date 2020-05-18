package com.zp.util;

import cn.hutool.extra.mail.MailUtil;

public class MailUtilTest {
    public static void main(String[] args) {
        //发送普通文本邮件，最后一个参数可选是否添加多个附件：
        MailUtil.send("zhangpeng98@aliyun.com", "测试", "邮件来自Hutool测试", false);
    }


}
