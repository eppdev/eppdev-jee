/*
 * # FileUtils.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-09
 */
package cn.eppdev.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文本文件读写的工具类
 *
 * @author fan.hao
 */
public class TextFileUtils {
    static Logger logger = LoggerFactory.getLogger(TextFileUtils.class);

    private static final String FILE_ENCODING = "UTF-8";

    private static final String EOL = "\n";

    /**
     * 将文本文件的全部文本内容
     *
     * @param filePath 文件的绝对地址
     * @return 全部内容
     * @throws IOException 文件读取异常
     */
    public static String readToString(String filePath) throws IOException {
        return readToString(filePath, FILE_ENCODING);
    }

    /**
     * 读取文本文件的全部内容
     *
     * @param filePath 文件绝对地址
     * @param encoding 文件编码
     * @return 全部文本内容
     * @throws IOException 文件读取异常
     */
    public static String readToString(String filePath, String encoding)
            throws IOException {
        return readToString(new File(filePath), encoding);
    }

    /**
     * 读取文本文件的全部内容
     *
     * @param file 要读取的文件
     * @return 全部文本内容
     * @throws IOException 文件读取异常
     */
    public static String readToString(File file) throws IOException {
        return readToString(file, FILE_ENCODING);
    }

    /**
     * 读取文本文件的全部内容
     *
     * @param file     要读取的文件
     * @param encoding 文件编码
     * @return 全部文本内容
     * @throws IOException 文件读取异常
     */
    public static String readToString(File file, String encoding)
            throws IOException {
        return readToString(new FileInputStream(file), encoding);
    }

    /**
     * 读取文本文件的全部内容
     *
     * @param is 输入流
     * @return 全部文本内容
     * @throws IOException 文件读取异常
     */
    public static String readToString(InputStream is) throws IOException {
        return readToString(is, FILE_ENCODING);
    }

    /**
     * 读取文本文件的全部内容
     *
     * @param is       输入流
     * @param encoding 编码
     * @return 全部文本内容
     * @throws IOException 文件读取异常
     */
    public static String readToString(InputStream is, String encoding)
            throws IOException {
        return readToString(new InputStreamReader(is, encoding));
    }

    /**
     * 读取文本文件的全部内容
     *
     * @param reader Reader对象
     * @return 全部文本内容
     * @throws IOException 文件读取异常
     */
    public static String readToString(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        int data;
        while ((data = br.read()) != -1) {
            sb.append((char) data);
        }
        br.close();
        return sb.toString();
    }

    /**
     * 将文本内容分行保存在List对象中
     *
     * @param filePath 文件绝对地址
     * @return 分行文件列表
     * @throws IOException 文件读取异常
     */
    public static List<String> readToList(String filePath) throws IOException {
        return readToList(filePath, FILE_ENCODING);
    }

    /**
     * 将文本内容分行保存在List对象中
     *
     * @param filePath 文件绝对地址
     * @param encoding 文件编码
     * @return 分行文件列表
     * @throws IOException 文件读取异常
     */
    public static List<String> readToList(String filePath, String encoding)
            throws IOException {
        return readToList(new File(filePath), encoding);
    }

    /**
     * 将文本内容分行保存在List对象中
     *
     * @param file 要读取的文件对象
     * @return 分行文本列表
     * @throws IOException 文件读写异常
     */
    public static List<String> readToList(File file) throws IOException {
        return readToList(file, FILE_ENCODING);
    }

    /**
     * 将文本内容分行保存在List对象中
     *
     * @param file     要读取的文件对象
     * @param encoding 文件编码
     * @return 分行文本列表
     * @throws IOException 文件读写异常
     */
    public static List<String> readToList(File file, String encoding)
            throws IOException {
        return readToList(new FileInputStream(file), encoding);
    }

    /**
     * 将文本内容分行保存在List对象中
     *
     * @param is 输入流
     * @return 分行文本列表
     * @throws IOException 文件读取异常
     */
    public static List<String> readToList(InputStream is) throws IOException {
        return readToList(is, FILE_ENCODING);
    }

    /**
     * 将文本内容分行保存在List对象中
     *
     * @param is       输入流
     * @param encoding 编码
     * @return 分行文本列表
     * @throws IOException 文件读取异常
     */
    public static List<String> readToList(InputStream is, String encoding)
            throws IOException {
        return readToList(new InputStreamReader(is, encoding));
    }

    /**
     * 将文本内容分行保存在List对象中
     *
     * @param reader Reader对象
     * @return 分行文本列表
     * @throws IOException 我那件读取异常
     */
    public static List<String> readToList(Reader reader) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(reader);
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }

        br.close();
        return list;
    }

    /**
     * 将文本写入到文件中
     *
     * @param content  文件内容
     * @param filePath 文件绝对地址
     * @throws IOException 文件写异常
     */
    public static void writeFile(String content, String filePath)
            throws IOException {
        writeFile(content, filePath, FILE_ENCODING);
    }

    /**
     * 将文本写入到文件中
     *
     * @param content  文件内容
     * @param filePath 文件绝对地址
     * @param encoding 编码
     * @throws IOException 文件写异常
     */
    public static void writeFile(String content, String filePath,
                                 String encoding) throws IOException {
        writeFile(content, new File(filePath), encoding);
    }

    /**
     * 将文本写入到文件中
     *
     * @param content 文件内容
     * @param file    文件对象
     * @throws IOException 文件写异常
     */
    public static void writeFile(String content, File file) throws IOException {
        writeFile(content, file, FILE_ENCODING);
    }

    /**
     * 将文本写入到文件中
     *
     * @param content  文件内容
     * @param file     文件对象
     * @param encoding 编码
     * @throws IOException 文件写异常
     */
    public static void writeFile(String content, File file, String encoding)
            throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoding);
        writer.write(content);
        writer.flush();
        writer.close();
    }


    /**
     * 将文本写入到文件中
     *
     * @param contentList 要写入的字符串列表
     * @param filePath    要写入的文件绝对路径
     * @throws IOException 文件写异常
     */
    public static void writeFile(List<String> contentList, String filePath) throws IOException {
        writeFile(contentList, filePath, FILE_ENCODING);
    }

    /**
     * 将文本写入到文件中
     *
     * @param contentList 要写入的字符串列表
     * @param filePath    要写入的文件绝对路径
     * @param encoding    文件编码
     * @throws IOException 文件写异常
     */
    public static void writeFile(List<String> contentList, String filePath, String encoding) throws IOException {
        writeFile(contentList, new File(filePath), encoding);
    }

    /**
     * 将文本写入到文件中
     *
     * @param contentList 要写入的字符串列表
     * @param file        要写入的文件对象
     * @throws IOException 文件写异常
     */
    public static void writeFile(List<String> contentList, File file) throws IOException {
        writeFile(contentList, file, FILE_ENCODING);
    }

    /**
     * 将文本写入到文件中
     *
     * @param contentList 要写入的字符串列表
     * @param file        要写入的文件对象
     * @param encoding    文件编码
     * @throws IOException 文件写异常
     */
    public static void writeFile(List<String> contentList, File file, String encoding) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), encoding);
        for (String str : contentList) {
            writer.write(str);
            writer.write(EOL);
        }
        writer.flush();
        writer.close();
    }
}
