/*
 * # SourceFileUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2015-10-10
 */
package cn.eppdev.codegenerator.utils.file;

import cn.eppdev.utils.file.TextFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author fan.hao
 */
public class SourceFileUtils {
    static Logger logger = LoggerFactory.getLogger(SourceFileUtils.class);

    /**
     * 读取源文件内容
     *
     * @param srcDir      源文件根目录
     * @param packageName 源文件所在的包名
     * @param fileName    文件名称
     * @return 文件全文
     * @throws IOException 读取异常
     */
    public static String readSourceFileToString(String srcDir, String packageName,
                                                String fileName) throws IOException {
        String filePath = srcDir + "/" + packageName.replace('.', '/') + "/"
                + fileName;
        return TextFileUtils.readToString(filePath);
    }

    /**
     * 读取源文件内容
     *
     * @param workSpaceDir 工程所在文件夹
     * @param projectDir   项目名称
     * @param srcDir       工程目录下源文件所在文件夹
     * @param packageName  包名
     * @param fileName     文件名
     * @return 文件全文
     * @throws IOException 读取异常
     */
    public static String readSourceFileToString(String workSpaceDir, String projectDir,
                                                String srcDir, String packageName,
                                                String fileName) throws IOException {
        return readSourceFileToString(workSpaceDir + "/" + projectDir + "/" +srcDir, packageName, fileName);
    }

    /**
     * 读取源文件内容，并分行保存到列表中
     *
     * @param srcDir      源文件根目录
     * @param packageName 源文件所在的包名
     * @param fileName    文件名称
     * @return 文件全文
     * @throws IOException 读取异常
     */
    public static List<String> readSourceFileToList(String srcDir,
                                                    String packageName, String fileName) throws IOException {

        return TextFileUtils.readToList(srcDir + "/"
                + packageName.replace('.', '/') + "/" + fileName);
    }

    /**
     * 写相应的源文件
     *
     * @param srcDir      源文件根目录
     * @param packageName 包名
     * @param fileName    文件名
     * @param content     要写的内容
     * @throws IOException 文件读写异常
     */
    public static void writeSourceFile(String srcDir, String packageName,
                                       String fileName, String content) throws IOException {
        String fileDir = srcDir + "/" + packageName.replace('.', '/') + "/";
        File file = new File(fileDir);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            throw new IOException(fileDir + " is not a directory!");
        }
        TextFileUtils.writeFile(content, fileDir + fileName);
    }

    /**
     * @param workSpaceDir 工程所在文件夹
     * @param projectDir   项目名称
     * @param srcDir       工程目录下源文件所在文件夹
     * @param packageName  包名
     * @param fileName     文件名
     * @param content      要写的内容
     * @throws IOException
     */
    public static void writeSourceFile(String workSpaceDir, String projectDir,
                                       String srcDir, String packageName,
                                       String fileName, String content) throws IOException {
        writeSourceFile(workSpaceDir + "/" + projectDir + "/" + srcDir, packageName, fileName, content);
    }


    /**
     * 判断文件是否存在
     *
     * @param srcDir      源文件根目录
     * @param packageName 源文件所在的根目录
     * @param fileName    文件名
     * @return 文件是否存在
     */
    public static boolean exists(String srcDir, String packageName,
                                 String fileName) {
        File file = new File(srcDir + "/" + packageName.replace('.', '/') + "/"
                + fileName);
        return file.exists();
    }

    /**
     * 判断文件是否存在
     *
     * @param workSpaceDir 工程所在文件夹
     * @param projectDir   项目名称
     * @param packageName  包名
     * @param fileName     文件名
     * @return 文件是否存在
     */
    public static boolean exists(String workSpaceDir, String projectDir,
                                 String srcDir, String packageName, String fileName) {
        return exists(workSpaceDir + "/" + projectDir + "/" + srcDir, packageName, fileName);
    }


    // public static void main(String[] args) throws IOException {
    // writeSourceFile("/home/haojinlong/2-dev/111/222/", "test.t",
    // "file.java", "file");
    // }
}
