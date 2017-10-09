/*
 * FileName: DateUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 17-9-20
 */

package cn.eppdev.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Date Utils.
 *
 * @author fan.hao
 */
public class DateUtils {

    private static final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static final DateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private static final DateFormat simpleDateTimeMilliSecFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");

    /**
     * generate current date string.
     *
     * @return current date str. (pattern is 'yyyy-MM-dd')
     */
    public static String getCurrentDate() {
        return simpleDateFormat.format(new Date());
    }

    /**
     * generate current date time string.
     *
     * @return current date time str. (pattern is 'yyyy-MM-dd hh:mm:ss')
     */
    public static String getCurrentDateTime() {
        return simpleDateTimeFormat.format(new Date());
    }

    /**
     * generate current date time string with milliseconds.
     *
     * @return current date time str. (pattern is 'yyyy-MM-dd hh:mm:ss:SSS')
     */
    public static String getCurrentDateTimeWithMilliSec() {
        return simpleDateTimeMilliSecFormat.format(new Date());
    }

}
