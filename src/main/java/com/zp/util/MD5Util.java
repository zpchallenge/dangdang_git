package com.zp.util;

import cn.hutool.crypto.digest.DigestUtil;

public class MD5Util {
    public static void main(String[] args) {
        String hello = DigestUtil.md5Hex ("hello");
        String hello2 = DigestUtil.md5Hex ("hello");
        String hello3 = DigestUtil.md5Hex ("hello!");
        System.out.println (hello);
        System.out.println (hello2);
        System.out.println (hello3);
    }
}
