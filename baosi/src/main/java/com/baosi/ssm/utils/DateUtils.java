package com.baosi.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换成字符串
    public static String date2String(Date date, String form) {
        SimpleDateFormat sdf = new SimpleDateFormat(form);
        String str = sdf.format(date);
        return str;
    }

    //字符串转换成日期
    public static Date string2Date(String str, String form) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(form);
        Date date = sdf.parse(str);
        return date;
    }
}
