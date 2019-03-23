package com.mass.biz.smart.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.user.model.SzUser;

@Mapper
public interface SzUserMapper {
	
	int insert(SzUser szUser);
	
    int delete(@Param("rid") long rid,@Param("delFlag") long delFlag);
    
    int update(SzUser szUser);

    SzUser getEntityById(@Param("rid")long rid);
    
    SzUser getEntityByOpendId(@Param("openId")String openId);
	
    List<SzUser> selectPageList(@Param("searchParams") SzUser params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    Long count(@Param("searchParams")SzUser szUser);

    Long countByIdCode(@Param("szUser")SzUser szUser);

    int batchInsert(List<SzUser> szUserList);
    
    int updateBatch(@Param("list") List<SzUser> list);
    
    List<SzUser> selectListByCondition(@Param("searchParams") SzUser params);
    
    SzUser validManager(@Param("searchParams")  SzUser szUser);
    
    /**
     * 更新用户类型
     * @param szUser
     * @return
     */
    int updateType(SzUser szUser);
    
    /**
     *查询type==1||2
     * @return
     */
    List<SzUser> selectTypeOT();

    /**
     * 
     * @Title:selectUserByType
     * @Description:(根据type查询用户信息rid)
     * @return:List<SzUser>(返回类型)  
     * @author:hq 
     * @throws
     */
    
    List<SzUser> selectUserByType(@Param("type")Integer type);
    
    int updateByRid(SzUser szUser);
    
    //<!-- 不再是负责人，修改为普通员工type=1 -->
    int updateWhenNotMerchant(SzUser szUser);

}
