/*
 * FileName: StringUtilsTest.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.utils;

import cn.eppdev.utils.string.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author fan.hao
 */
public class StringUtilsTest {


    @Test
    public void testRemove(){
        String content = ",haojinlong, yangjie,";
        String toRemove = ",";
        Assert.assertEquals("haojinlong, yangjie", StringUtils.removeBeforeAndEnd(content, toRemove));
    }
}
