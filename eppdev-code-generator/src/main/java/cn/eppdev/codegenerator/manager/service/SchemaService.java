/*
 * FileName: SchemaService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-12
 */

package cn.eppdev.codegenerator.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fan.hao
 */
@Service
public class SchemaService {
    @Autowired
    DataSource dataSource;


    public List<String> listTablesFromConn(){
        List<String> tableList = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            String[] tableTypes = {"TABLE", "VIEW"};
            ResultSet rs = conn.getMetaData().getTables(null,
                    null,
                    null,
                    tableTypes);
            while(rs.next()){
                tableList.add(rs.getString("TABLE_NAME"));
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }
}
