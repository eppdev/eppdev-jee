/*
 * FileName: EppdevConfService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-01
 */

package cn.eppdev.codegenerator.manager.service;

import cn.eppdev.codegenerator.manager.entity.EppdevConf;
import cn.eppdev.commons.service.BasicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fan.hao
 */
@Service
@Transactional(readOnly = true)
public class EppdevConfService extends BasicService<EppdevConf> {
    @Override
    public boolean exists(EppdevConf entity) {
        return false;
    }

    @Override
    public void customeInit(EppdevConf entity) {
    }

    public Map<String, String> getBasicMap(){
        Map<String, String> result = new HashMap<>();
        List<EppdevConf> confList = listAll().getList();
        for(EppdevConf conf: confList){
            result.put(conf.getConfName(), conf.getConfValue());
        }
        result.put("PACKAGE_NAME_DIR", result.get("PACKAGE_NAME").replace('.', '/'));
        return result;
    }

    public String getBasicPackageName(){
        return getBasicMap().get("PACKAGE_NAME");
    }

    public String getWorkSpaceDir(){
        return  getBasicMap().get("WORK_SPACE_DIR");
    }

    public String getProjectName(){
        return getBasicMap().get("PROJECT_NAME");
    }
}
