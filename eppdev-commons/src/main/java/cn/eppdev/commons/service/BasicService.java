/*
 * FileName: BasicService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-9-20
 */

package cn.eppdev.commons.service;

import cn.eppdev.commons.dao.BasicDao;
import cn.eppdev.commons.utils.DaoPeropertiesUtils;
import cn.eppdev.utils.DateUtils;
import cn.eppdev.utils.UUIDUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础Service类，提供了一些基础的方法
 *
 * @author fan.hao
 */
@Transactional(readOnly = true)
public class BasicService<T extends BasicDao> {

    private static final String PAGE_SIZE_KEY = DaoPeropertiesUtils.get("PAGE_SIZE_KEY");
    private static final String PAGE_NUM_KEY = DaoPeropertiesUtils.get("PAGE_NUM_KEY");

    private static final String PROPERTY_ID = DaoPeropertiesUtils.get("PROPERTY_ID");
    private static final String PROPERTY_CREATE_DATE = DaoPeropertiesUtils.get("PROPERTY_CREATE_DATE");
    private static final String PROPERTY_UPDATE_DATE = DaoPeropertiesUtils.get("PROPERTY_UPDATE_DATE");
    private static final String PROPERTY_DEL_FLAG = DaoPeropertiesUtils.get("PROPERTY_DEL_FLAG");

    private static final Integer DEL_FLAG_NORMAL = 0;

    @Autowired
    T dao;

    /**
     * 获取一条数据
     *
     * @param id 数据ID
     * @return 单条数据
     */
    public Map<String, Object> get(String id) {
        return dao.get(id);
    }

    /**
     * 删除一条数据
     *
     * @param id 要删除的数据ID
     * @return 实际删除的数据条数
     */
    @Transactional(readOnly = false)
    public int delete(String id) {
        return dao.delete(id);
    }

    /**
     * 保存数据，若存在ID，则执行更新操作，若不存在，则执行插入操作
     *
     * @param entityMap 要保存的数据对象
     * @return 保存的数据条数
     */
    @Transactional(readOnly = false)
    public int save(Map<String, Object> entityMap) {
        String dataStr = DateUtils.getCurrentDateTimeWithMilliSec();
        if (null == entityMap.get(PROPERTY_ID)) { // new entity，do insert
            entityMap.put(PROPERTY_CREATE_DATE, dataStr);
            entityMap.put(PROPERTY_UPDATE_DATE, dataStr);
            entityMap.putIfAbsent(PROPERTY_DEL_FLAG, DEL_FLAG_NORMAL);
            entityMap.put(PROPERTY_ID, UUIDUtils.getUUID());
            return dao.insert(entityMap);
        } else {
            entityMap.put(PROPERTY_UPDATE_DATE, dataStr);
            return dao.update(entityMap);
        }
    }

    public PageInfo<Map<String, Object>> listAll() {
        return new PageInfo<>(dao.listAll(null));
    }

    /**
     * 获取分页列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Map<String, Object>> listAll(int pageNum, int pageSize) {
        Map<String, Object> entityMap = new HashMap<>();
        entityMap.put(PAGE_NUM_KEY, pageNum);
        entityMap.put(PAGE_SIZE_KEY, pageSize);
        return new PageInfo<>(dao.listAll(entityMap));
    }

    /**
     * 获取分页列表
     * @param paramMap
     * @return
     */
    public PageInfo<Map<String, Object>> listBy(Map paramMap){
        return new PageInfo<>(dao.listBy(paramMap));
    }

    /**
     * 获取分页列表
     * @param paramMap
     * @return
     */
    public PageInfo<Map<String, Object>> listLike(Map paramMap){
        return new PageInfo<>(dao.listLike(paramMap));
    }


    /**
     * 获取分页列表
     * @param paramMap
     * @return
     */
    public PageInfo<Map<String, Object>> listLeftLike(Map paramMap){
        return new PageInfo<>(dao.listLeftLike(paramMap));
    }


    /**
     * 获取分页列表
     * @param paramMap
     * @return
     */
    public PageInfo<Map<String, Object>> listRawLike(Map paramMap){
        return new PageInfo<>(dao.listRawLike(paramMap));
    }

}
