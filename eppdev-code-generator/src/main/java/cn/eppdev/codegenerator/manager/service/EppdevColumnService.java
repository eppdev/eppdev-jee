/*
 * FileName: EppdevColumnService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.manager.service;

import cn.eppdev.codegenerator.manager.dao.EppdevColumnDao;
import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.utils.conf.TypesMapperUtils;
import cn.eppdev.codegenerator.utils.name.NameUtils;
import cn.eppdev.commons.service.BasicService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: fan.hao
 */
@Service
@Transactional(readOnly = true)
public class EppdevColumnService extends BasicService<EppdevColumn> {

    @Override
    public boolean exists(EppdevColumn entity) {
        EppdevColumn param = new EppdevColumn();
        param.setColumnName(entity.getColumnName());
        param.setTableId(entity.getTableId());
        PageInfo<EppdevColumn> info = listBy(param, 1,1 );
        if(info.getTotal() > 0){
            return true;
        }
        return false;
    }

    @Override
    public void customeInit(EppdevColumn entity) {
        entity.setPropertyName(NameUtils.buildPropertyName(entity.getColumnName()));
        entity.setJavaType(TypesMapperUtils.getJavaType(entity.getColumnType()));
        if(null == entity.getSortIndex()){
            entity.setSortIndex(100);
        }
    }
}
