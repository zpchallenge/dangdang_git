package com.zp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringUtil {
    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        String format = sdf.format (date);
        return format;
    }

    public static void main(String[] args) {
        System.out.println (dateToString (new Date ()));
    }
}
