/*
 * FileName: Application.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-12
 */

package cn.eppdev.codegenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: fan.hao
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.eppdev.codegenerator"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
