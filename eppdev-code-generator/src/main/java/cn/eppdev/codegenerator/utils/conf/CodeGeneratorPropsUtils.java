/*
 * FileName: CodeGeneratorPropsUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.codegenerator.utils.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author fan.hao
 */
public class CodeGeneratorPropsUtils {

    private static Logger logger = LoggerFactory.getLogger(CodeGeneratorPropsUtils.class);

    private static Properties CG_PROPS = new Properties();

    private static final String PROJECT_DIR_KEY = "project_dir";

    private static final String PROJECT_NAME_KEY = "project_name";

    private static final String PACKAGE_NAME_KEY = "package_name";

    private static final String USER_NAME_KEY = "user_name";

    private static final String USER_EMAIL_KEY = "user_email";

    static{
        try {
            CG_PROPS.load(CodeGeneratorPropsUtils.class.getResourceAsStream("/eppdev-code-generator.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProjectDir(){
        return CG_PROPS.getProperty(PROJECT_DIR_KEY);
    }

    public static String getProjectName(){
        return CG_PROPS.getProperty(PROJECT_NAME_KEY);
    }

    public static String getPackageName(){
        return CG_PROPS.getProperty(PACKAGE_NAME_KEY);
    }
}
