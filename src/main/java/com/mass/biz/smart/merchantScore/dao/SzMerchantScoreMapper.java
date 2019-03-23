package com.mass.biz.smart.merchantScore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.merchantScore.model.SzMerchantScore;

@Mapper
public interface SzMerchantScoreMapper {
	
	int insert(SzMerchantScore szMerchantScore);
	
    int delete(@Param("rid") long rid);
    
    int update(SzMerchantScore szMerchantScore);

    SzMerchantScore getEntityById(@Param("rid")long rid);
	
    List<SzMerchantScore> selectPageList(@Param("searchParams") SzMerchantScore params, @Param("page") Integer offset, @Param("limit") Integer limit);

    Long count(SzMerchantScore szMerchantScore);
    
    List<SzMerchantScore> selectIndexList(@Param("searchParams") SzMerchantScore params, @Param("page") Integer offset, @Param("limit") Integer limit);

    Long indexListCount(SzMerchantScore szMerchantScore);
    
    Long selectThelastScore(SzMerchantScore szMerchantScore);
    
    /**
     * 批量操作，用SzMerchantMgt.id
     * @param list
     * @return
     */
    int batchInsert(List<SzMerchantScore> list);
    
    /**
     * 外部调用接口
     * @param szMerchantScore
     * @return
     */
    int outsideInsert(SzMerchantScore szMerchantScore);

}