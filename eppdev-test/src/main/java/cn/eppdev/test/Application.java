/*
 * #Application.java -- 项目启动类
 * 作者: fan.hao-(fan.hao@eppdev.cn)
 * 日期: 2017-11-04
 */

package cn.eppdev.test;

import cn.eppdev.test.eppdev.service.EppdevColumnService;
import cn.eppdev.utils.json.JSONUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: fan.hao
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.eppdev.test"})
public class Application implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    EppdevColumnService columnService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(JSONUtils.toJson(columnService.listAll()));
    }
}