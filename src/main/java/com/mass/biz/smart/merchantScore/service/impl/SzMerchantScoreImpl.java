package com.mass.biz.smart.merchantScore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.merchantScore.dao.SzMerchantScoreMapper;
import com.mass.biz.smart.merchantScore.model.SzMerchantScore;
import com.mass.biz.smart.merchantScore.service.SzMerchantScoreService;

@Service
public class SzMerchantScoreImpl implements SzMerchantScoreService {
	
	@Autowired
	private SzMerchantScoreMapper szMerchantScoreMapper;
	
	@Override
	public int insert(SzMerchantScore szMerchantScore) {
		Long last_socre = szMerchantScore.getLast_sore();
		Long score = szMerchantScore.getScore();
		//分数变化
		if(last_socre!=null && score!=null)
			szMerchantScore.setChanges(score - last_socre);
		
		return szMerchantScoreMapper.insert(szMerchantScore);
	}

	@Override
	public int delete(long rid) {
		return szMerchantScoreMapper.delete(rid);
	}

	@Override
	public int update(SzMerchantScore szMerchantScore) {
		return szMerchantScoreMapper.update(szMerchantScore);
	}

	@Override
	public SzMerchantScore getEntityById(long rid) {
		return szMerchantScoreMapper.getEntityById(rid);
	}

	@Override
	public List<SzMerchantScore> selectPageList(SzMerchantScore params, Integer offset, Integer limit) {
		return szMerchantScoreMapper.selectPageList(params, offset, limit);
	}

	@Override
	public Long count(SzMerchantScore szMerchantScore) {
		return szMerchantScoreMapper.count(szMerchantScore);
	}

	@Override
	public List<SzMerchantScore> selectIndexList(SzMerchantScore params, Integer offset, Integer limit) {
		return szMerchantScoreMapper.selectIndexList(params, offset, limit);
	}

	@Override
	public Long indexListCount(SzMerchantScore szMerchantScore) {
		return szMerchantScoreMapper.indexListCount(szMerchantScore);
	}

	@Override
	public Long selectThelastScore(SzMerchantScore szMerchantScore) {
		return szMerchantScoreMapper.selectThelastScore(szMerchantScore);
	}

	@Override
	public int enterInsert(SzMerchantScore szMerchantScore) {
		szMerchantScore.setScore(SzMerchantScore.MERCAHNT_ENTER_SCORE);
		szMerchantScore.setChanges(SzMerchantScore.MERCAHNT_ENTER_SCORE);
		szMerchantScore.setDescription(SzMerchantScore.MERCAHNT_ENTER_DESC);
		return szMerchantScoreMapper.insert(szMerchantScore);
	}

	@Override
	public int batchInsert(List<SzMerchantScore> list) {
		return szMerchantScoreMapper.batchInsert(list);
	}

	@Override
	public int outsideInsert(Long merchant_id,Long changes,String description) {
		
		SzMerchantScore szMerchantScore = new SzMerchantScore();
		szMerchantScore.setMerchant_id(merchant_id);
		szMerchantScore.setChanges(changes);
		szMerchantScore.setDescription(description);
		Long last_score = szMerchantScoreMapper.selectThelastScore(szMerchantScore);
		if(last_score!=null && last_score>0l)
			szMerchantScore.setScore(last_score - szMerchantScore.getChanges());
		return szMerchantScoreMapper.insert(szMerchantScore);
	}

	@Override
	public int outsideInsert(Long user_id, int type) {
		if(user_id != null){
			SzMerchantScore score = new SzMerchantScore();
			score.setUser_id(user_id);
			score.setChanges(SzMerchantScore.getScoreByType(type));
			score.setDescription(SzMerchantScore.getDescByType(type));
			return szMerchantScoreMapper.outsideInsert(score);
		}
		return 0;
	}

}