package com.mass.biz.smart.services.Increment.service.impl;

import com.mass.biz.smart.services.Increment.dao.IncrementMapper;
import com.mass.biz.smart.services.Increment.model.Increment;
import com.mass.biz.smart.services.Increment.service.IncrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName 增值服务
 * @Author 郑上进
 * @Date 2018/8/13 14:21
 * @Version 1.0
 **/
@Service
public class IncrementServiceImpl implements IncrementService {


    @Autowired
    private IncrementMapper incrementMapper;

    /*后台管理*/

    /**
     * 列表及分页查询
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    @Override
    public List<Increment> selectPageList(Increment increment, Integer pageIndex, Integer pageSize) {
        List<Increment> list = incrementMapper.selectPageList(increment, pageIndex, pageSize);
        return list;
    }

    /**
     * 统计总条数
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    @Override
    public long count(Increment increment) {
        return this.incrementMapper.count(increment);
    }

    /**
     * 删除数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/
    @Override
    public boolean deleteEntity(Long id) {
        return 0 < this.incrementMapper.delete(id);
    }

    /**
     * 根据id查询数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/
    @Override
    public Increment getEntityById(Long id) {
        return this.incrementMapper.getEntityById(id);
    }

    /**
     * 修改数据
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    @Override
    public boolean editEntity(Increment increment) {
        return 0 < this.incrementMapper.update(increment);
    }


    /*微信端*/

    /**
     * @Name 新增数据
     * @Param contract
     * @Author 郑上进
     * @Date 15:57 2018/8/07
     **/
    @Override
    public Increment addEntity(Increment increment) {
        boolean b = 0 < this.incrementMapper.insert(increment);
        return b ? increment : null;
    }


    /**
     * @Name 根据用户id查询所有申请的增值服务
     * @Param applyUserId
     * @Author 郑上进
     * @Date 11:06 2018/8/17
     **/
    @Override
    public List<Increment> getEntityByUserId(Long applyUserId) {
        List<Increment> incrementList = this.incrementMapper.getEntityByUserId(applyUserId);
        return incrementList;
    }


    /**
     * @Name 根据用户id和id查询单条增值服务详情
     * @Param object
     * @Author 郑上进
     * @Date 14:28 2018/8/17
     **/
    @Override
    public Increment getByIdByUserId(Increment increment) {
        return this.incrementMapper.getByIdByUserId(increment);
    }


}
