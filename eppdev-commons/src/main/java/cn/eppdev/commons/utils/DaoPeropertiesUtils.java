/*
 * FileName: DaoPeropertiesUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 17-9-20
 */

package cn.eppdev.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * DAO相关配置文件读取工具类
 * @author fan.hao
 */
public class DaoPeropertiesUtils {

    private static Logger logger = LoggerFactory.getLogger(DaoPeropertiesUtils.class);

    // 用户自定义的配置文件路径【classpath中】
    private static final String CONF_FILE_PATH = "/eppdev-dao-conf.properties";

    //系统默认的配置文件路径【classpath中】
    private static final String DEFAULT_CONF_FILE_PATH = "/eppdev-dao-conf_default.properties";

    private static Properties PROPERTIES = new Properties();

    static {
        try {  // 读取默认配置
            PROPERTIES.load(DaoPeropertiesUtils.class.getResourceAsStream(DEFAULT_CONF_FILE_PATH));
        } catch (IOException e) {
            logger.error("Error: {}", e.getMessage());
            logger.error("Caused by: {}", e.getCause());
            logger.error("StackTrace: {}", e.getStackTrace());
        }

        try {  // 读取用户自定义配置
            PROPERTIES.load(DaoPeropertiesUtils.class.getResourceAsStream(CONF_FILE_PATH));
        } catch (Exception e) {
            logger.info("Cannot load dao configure file: {}. Use Default configurations.", CONF_FILE_PATH);
        }
    }

    /**
     * 获取配置
     * @param key 关键词
     * @return 配置内容
     */
    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

}
