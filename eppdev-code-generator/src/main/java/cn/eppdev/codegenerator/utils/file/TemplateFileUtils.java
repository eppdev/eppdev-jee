/*
 * FileName: TemplateFileUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.utils.file;

import cn.eppdev.utils.file.TextFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 模板文件读取的工具类
 * @author: fan.hao
 */
public class TemplateFileUtils {
    private static Logger logger = LoggerFactory.getLogger(TemplateFileUtils.class);

    /**
     * 读取模板文件
     * @param filePath 文件路径
     * @return 文件内容
     */
    public static String read(String filePath) {
        try {
            return TextFileUtils.readToString(TemplateFileUtils.class.getResourceAsStream(filePath));
        } catch (IOException e) {
            logger.error("Error while read templateFile: {}", filePath);
            e.printStackTrace();
        }
        return null;
    }
}
