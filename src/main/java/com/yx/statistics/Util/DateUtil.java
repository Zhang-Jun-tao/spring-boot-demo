package com.yx.statistics.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhang on 2016/12/9.
 */
public class DateUtil {

    private static  final String YMDHMS_PATTERN="yyyy-MM-dd HH:mm:ss";

    public static String dateToyMdHms(Date date){
        if (date ==null)
            return null;
        SimpleDateFormat sdf =new SimpleDateFormat(YMDHMS_PATTERN);
        return  sdf.format(date);
    }


    public static Date yMdHmsToDate(String yMdHms)throws Exception{
        if (!CommonUtil.isYMDHMS(yMdHms))
            return null;
        SimpleDateFormat sdf =new SimpleDateFormat(YMDHMS_PATTERN);
        return sdf.parse(yMdHms);
    }

}
