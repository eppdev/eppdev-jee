/*
 * FileName: DateUtilsTest.java
 * Author: Fan.Hao hao.fan@eppdev.cn
 * Date: 17-10-9
 */

package cn.eppdev.utils;

import cn.eppdev.utils.date.DateUtils;
import org.junit.Test;

import java.text.ParseException;

/**
 * @author fan.hao
 */
public class DateUtilsTest {

    @Test
    public void testDate(){
        System.out.println(DateUtils.getCurrentDateTime());
    }

    @Test
    public void testParse(){
        try {
            System.out.println(DateUtils.parseDate("2017-03-15 13:24:55:009"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
