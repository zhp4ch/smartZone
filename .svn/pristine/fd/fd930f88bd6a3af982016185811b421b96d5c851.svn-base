package com.mass.biz.smart.merchantScore.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.merchant.model.SzMerchant;
import com.mass.biz.smart.merchantMgt.model.SzMerchantMgt;
import com.mass.biz.smart.merchantScore.model.SzMerchantScore;

public interface SzMerchantScoreService {

    int insert(SzMerchantScore szMerchantScore);
	
    int delete(@Param("rid") long rid);
    
    int update(SzMerchantScore szMerchantScore);

    SzMerchantScore getEntityById(@Param("rid")long rid);
	
    List<SzMerchantScore> selectPageList(@Param("searchParams") SzMerchantScore params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    Long count(SzMerchantScore szMerchantScore);
    
    List<SzMerchantScore> selectIndexList(@Param("searchParams") SzMerchantScore params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    Long indexListCount(SzMerchantScore szMerchantScore);
    
    Long selectThelastScore(SzMerchantScore szMerchantScore);
   
    /**
     * 审核通过时，调用的接口
     * @param szMerchantScore
     * @return
     */
    int enterInsert(SzMerchantScore szMerchantScore);
    
    /**
     * 批量操作，用SzMerchantMgt.id
     * @param list
     * @return
     */
    int batchInsert(List<SzMerchantScore> list);
    /**
     * 供外部调用(弃用)
     * @param merchant_id 商户ID
     * @param changes 分值变化
     * @param description 描述
     * @return
     */
    int outsideInsert(Long merchant_id,Long changes,String description);
    /**
     * 供外部调用
     * @param user_id 积分贡献人
     * @param type 积分类型
     * @return
     */
    int outsideInsert(Long user_id,int type);
}
