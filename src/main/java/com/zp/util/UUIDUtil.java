package com.zp.util;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID ().toString ();
    }

    public static void main(String[] args) {
        System.out.println (getUUID ()); //608a5fb5-436c-4c3d-82aa-01f4a4c1e9b0
    }
}
