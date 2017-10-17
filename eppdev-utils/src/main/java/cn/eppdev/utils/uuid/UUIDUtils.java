/*
 * FileName: UUIDUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-9-20
 */

package cn.eppdev.utils.uuid;

import java.util.UUID;

/**
 * UUID的工具类，用于生成新的UUID
 * @author fan.hao
 */
public class UUIDUtils {

    /**
     * 新创建一个UUID
     * @return 新的UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
