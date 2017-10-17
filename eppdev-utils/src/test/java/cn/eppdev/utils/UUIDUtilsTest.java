/*
 * FileName: UUIDUtilsTest.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.utils;

import cn.eppdev.utils.uuid.UUIDUtils;
import org.junit.Test;

/**
 * @author fan.hao
 */
public class UUIDUtilsTest {
    @Test
    public void testUUID(){
        for(int i=0; i<10; i++) {
            System.out.println(UUIDUtils.getUUID());
        }
    }
}
