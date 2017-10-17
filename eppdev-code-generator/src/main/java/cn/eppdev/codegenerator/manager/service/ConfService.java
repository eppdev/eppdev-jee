/*
 * FileName: ConfService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-15
 */

package cn.eppdev.codegenerator.manager.service;

import cn.eppdev.codegenerator.commons.entity.ColumnTypeStdEntity;
import cn.eppdev.codegenerator.utils.conf.TypeStdUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fan.hao
 */
@Service
public class ConfService {

    /**
     * 获取标准的可选列类型
     * @return
     */
    public List<ColumnTypeStdEntity> listStdColumnTypes(){
        return TypeStdUtils.getColumnStdList();
    }
}
