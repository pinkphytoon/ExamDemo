package cn.wolfcode.util;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TimeFormatUtils {
    public static String timeFormat(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mmm:ss aa EE");
        return sdf.format(date);
    }
}
