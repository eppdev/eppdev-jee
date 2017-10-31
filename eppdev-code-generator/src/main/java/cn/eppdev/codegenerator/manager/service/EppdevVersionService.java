/*
 * FileName: EppdevVersionService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-12
 */

package cn.eppdev.codegenerator.manager.service;

import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.manager.entity.EppdevIndex;
import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.manager.entity.EppdevVersion;
import cn.eppdev.commons.service.BasicService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fan.hao
 */
@Service
@Transactional(readOnly = true)
public class EppdevVersionService extends BasicService<EppdevVersion> {

    @Autowired
    EppdevTableService tableService;

    @Autowired
    EppdevColumnService columnService;

    @Autowired
    EppdevIndexService indexService;

    @Transactional(readOnly = false)
    public int createNewVersion(EppdevVersion eppdevVersion, String originVersion) {
        if (exists(eppdevVersion)) {
            return 0;
        }

        // 保存版本信息，生成新的versionId
        int count = this.save(eppdevVersion);
        if (count == 0) {
            throw new RuntimeException("保存失败");
        }

        // 查询所有的表信息，依次保存
        EppdevTable tableParam = new EppdevTable();
        tableParam.setVersionId(originVersion);
        PageInfo<EppdevTable> tablePageInfo = tableService.listBy(tableParam, null, null);
        for (EppdevTable table : tablePageInfo.getList()) {
            String originId = table.getId();
            table.setId(null);
            table.setVersionId(eppdevVersion.getId());
            count = tableService.save(table);  // 保存表信息，生成新的tableId
            if (count == 0) {
                throw new RuntimeException("保存失败");
            }

            // 查询表中所有的类
            EppdevColumn columnParam = new EppdevColumn();
            columnParam.setTableId(originId);
            PageInfo<EppdevColumn> columnPageInfo = columnService.listBy(columnParam, null, null);
            for (EppdevColumn column : columnPageInfo.getList()) {
                column.setId(null);
                column.setTableId(table.getId());
                count = columnService.save(column);
                if (count == 0) {
                    throw new RuntimeException("保存失败");
                }
            }

            // 查询所有的
            EppdevIndex indexParm = new EppdevIndex();
            indexParm.setTableId(originId);
            PageInfo<EppdevIndex> indexPageInfo = indexService.listBy(indexParm, null, null);
            for (EppdevIndex index : indexPageInfo.getList()) {
                index.setId(null);
                index.setTableId(table.getId());
                count = indexService.save(index);
                if (count == 0) {
                    throw new RuntimeException("保存失败");
                }
            }
        }
        return count;
    }


    public PageInfo<EppdevTable> listTables(String versionId) {
        EppdevTable tableParam = new EppdevTable();
        tableParam.setVersionId(versionId);
        PageInfo<EppdevTable> pageInfo = tableService.listBy(tableParam, null, null);
        return pageInfo;
    }

    @Override
    @Transactional
    public boolean exists(EppdevVersion entity) {
        EppdevVersion param = new EppdevVersion();
        param.setVersionName(entity.getVersionName());
        PageInfo<EppdevVersion> pageInfo = this.listBy(param, 1, 1);
        if(pageInfo.getTotal() > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void customeInit(EppdevVersion entity) {
    }
}
