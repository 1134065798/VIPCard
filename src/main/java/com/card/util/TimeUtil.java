package com.card.util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getCreateTime(){
        String createTime=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        createTime=sdf.format(new Date());
        return createTime;
    }
}
