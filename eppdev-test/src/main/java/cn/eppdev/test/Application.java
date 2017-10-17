/*
 * FileName: Application.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 17-9-21
 */

package cn.eppdev.test;

import cn.eppdev.test.entity.TestEntity;
import cn.eppdev.test.service.TestEntityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
        TestEntity paramEntiy = new TestEntity();
        paramEntiy.setName("name%");
        paramEntiy.setPageNum(2);
        paramEntiy.setPageSize(5);
        System.out.println(new ObjectMapper().writeValueAsString(testEntityService.listRawLike(paramEntiy)));
        System.out.println(new ObjectMapper().writeValueAsString(testEntityService.get("0001")));
        TestEntity testEntity = testEntityService.get("0002");
        testEntity.setDelFlag(1);
        testEntity.setName("nametest");
        System.out.println(testEntityService.get("0002"));
    }
}
