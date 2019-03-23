package com.mass.biz.smart.services.Contract.service.impl;

import com.mass.biz.smart.services.Contract.dao.ContractMapper;
import com.mass.biz.smart.services.Contract.model.Contract;
import com.mass.biz.smart.services.Contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName
 * @Author 郑上进
 * @Date 2018/8/7 9:56
 * @Version 1.0
 **/
@Service
public class ContractServiceImpl implements ContractService {


    @Autowired
    private ContractMapper contractMapper;


    /*后台管理*/

    /**
     * 列表及分页查询
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    @Override
    public List<Contract> selectPageList(Contract contract, Integer pageIndex, Integer pageSize) {
        List<Contract> list = contractMapper.selectPageList(contract, pageIndex, pageSize);
        return list;
    }

    /**
     * 统计总条数
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    @Override
    public long count(Contract contract) {
        return this.contractMapper.count(contract);
    }

    /**
     * @Name 新增数据
     * @Param contract
     * @Author 郑上进
     * @Date 15:57 2018/8/07
     **/
    @Override
    public Contract addEntity(Contract contract) {
        boolean b = 0< this.contractMapper.insert(contract);
        return b ? contract : null;
    }

    /**
     * 删除数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/
    @Override
    public boolean deleteEntity(Long id) {
        return 0 < this.contractMapper.delete(id);
    }


    /**
     * @Name 查询下载文件路径
     * @Param path
     * @Author 郑上进
     * @Date 18:20 2018/8/29
     **/
    @Override
    public Contract selectPath(String contractUrl) {
        return this.contractMapper.selectPath(contractUrl);
    }


    /**
     * 根据id查询数据
     *
     * @Author 郑上进
     * @Date 10:47 2018/8/07
     **/
    @Override
    public Contract getEntityById(Long id) {
        return this.contractMapper.getEntityById(id);
    }

    /**
     * 修改数据
     *
     * @Author 郑上进
     * @Date 10:46 2018/8/07
     **/
    @Override
    public boolean editEntity(Contract contract) {
        return 0 < this.contractMapper.update(contract);
    }


    /*微信端*/


    /**
     * @Name 微信-根据公司id查询该用户租赁合同；
     * @Param companyId
     * @Author 郑上进
     * @Date 9:16 2018/8/13
     **/
    @Override
    public List<Contract> getCompanyIdByZn(Long companyId) {
        List<Contract> contractList = contractMapper.getCompanyIdByZn(companyId);
        return contractList;
    }

    /**
     * @Name 微信-根据公司id查询该用户所有其他类型合同
     * @Param companyId
     * @Author 郑上进
     * @Date 9:17 2018/8/13
     **/
    @Override
    public List<Contract> getCompanyIdByQt(Long companyId) {
        List<Contract> contractList = contractMapper.getCompanyIdByQt(companyId);
        return contractList;
    }

}
