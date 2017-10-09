/*
 * FileName: Application.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 17-9-21
 */

package cn.eppdev.test;

import cn.eppdev.test.service.TestEntityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fan.hao
 */
@SpringBootApplication
@ComponentScan({"cn.eppdev"})
@MapperScan(basePackages = {
        "cn.eppdev.test.dao"
})
public class Application implements CommandLineRunner{

    @Autowired
    TestEntityService testEntityService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("pageNum", 2);
//        paramMap.put("pageSize", 5);
        System.out.println(new ObjectMapper().writeValueAsString(testEntityService.listAll()));
        System.out.println(new ObjectMapper().writeValueAsString(testEntityService.get("0001")));
        Map<String, Object> map = testEntityService.get("0002");
        map.put("name", "nametest");
        map.put("delFlag", 1);
        testEntityService.save(map);
        System.out.println(testEntityService.get("0002"));
    }
}
