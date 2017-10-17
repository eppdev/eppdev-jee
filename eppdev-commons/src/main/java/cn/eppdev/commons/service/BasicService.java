/*
 * FileName: BasicService.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-9-20
 */

package cn.eppdev.commons.service;

import cn.eppdev.commons.dao.BasicDao;
import cn.eppdev.commons.entity.BasicEntity;
import cn.eppdev.utils.uuid.UUIDUtils;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 基础Service类，提供了一些基础的方法
 *
 * @author fan.hao
 */
@Transactional(readOnly = true)
public abstract class BasicService<T extends BasicEntity> {

    private static Logger logger = LoggerFactory.getLogger(BasicService.class);

    public static final Integer DEL_FLAG_NORMAL = 0;

    @Autowired
    BasicDao<T> dao;

    /**
     * 获取一条数据
     *
     * @param id 数据ID
     * @return 单条数据
     */
    public T get(String id) {
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
     * @param entity 要保存的数据对象
     * @return 保存的数据条数
     */
    @Transactional(readOnly = false)
    public int save(T entity) {
        logger.debug("entity: {}", entity);

        if (null == entity.getId() || entity.getId().trim().length() == 0) { // new entity，do insert
            if (exists(entity)) { // 判断是否已经存在
                return 0;
            } else {
                _init(entity);
                return dao.insert(entity);
            }
        } else {
            entity.setUpdateTime(new Date());
            return dao.update(entity);
        }
    }


    public abstract boolean exists(T entity);

    public void _init(T entity) {
        Date date = new Date();
        entity.setId(UUIDUtils.getUUID());
        entity.setCreateTime(date);
        entity.setUpdateTime(date);
        entity.setDelFlag(DEL_FLAG_NORMAL);
        customeInit(entity);
    }

    public abstract void customeInit(T entity);

    public PageInfo<T> listAll() {
        return new PageInfo<>(dao.listAll(null));
    }

    /**
     * 获取分页列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<T> listAll(int pageNum, int pageSize) {
        BasicEntity entity = new BasicEntity();
        entity.setPageNum(pageNum);
        entity.setPageSize(pageSize);
        return new PageInfo<>(dao.listAll(entity));
    }

    /**
     * 获取分页列表
     *
     * @param paramEntity
     * @return
     */
    public PageInfo<T> listBy(T paramEntity) {
        return new PageInfo<>(dao.listBy(paramEntity));
    }

    /**
     * 获取分页列表
     *
     * @param paramEntity
     * @return
     */
    public PageInfo<T> listLike(T paramEntity) {
        return new PageInfo<>(dao.listLike(paramEntity));
    }


    /**
     * 获取分页列表
     *
     * @param paramEntity
     * @return
     */
    public PageInfo<T> listLeftLike(T paramEntity) {
        return new PageInfo<>(dao.listLeftLike(paramEntity));
    }


    /**
     * 获取分页列表
     *
     * @param paramEntity
     * @return
     */
    public PageInfo<T> listRawLike(T paramEntity) {
        return new PageInfo<>(dao.listRawLike(paramEntity));
    }

}
