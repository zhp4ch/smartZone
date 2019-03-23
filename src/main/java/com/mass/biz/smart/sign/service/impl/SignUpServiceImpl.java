package com.mass.biz.smart.sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.sign.dao.SignUpMapper;
import com.mass.biz.smart.sign.model.SignUpModel;
import com.mass.biz.smart.sign.service.SignUpService;

/**
 * 考勤打卡借口实现类
 * 
 * @author vm3
 * 
 */
@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpMapper signMapper;

	@Override
	public List<SignUpModel> selectPageList(SignUpModel signModel,
			Integer offset, Integer limit) {
		return signMapper.selectPageList(signModel, offset, limit);
	}

	@Override
	public Long count(SignUpModel signModel) {
		return signMapper.count(signModel);
	}

	@Override
	public List<SignUpModel> getUserDetail(SignUpModel signModel,
			Integer offset, Integer limit) {
		return signMapper.getUserDetail(signModel, offset, limit);
	}

	@Override
	public Long detailCount(SignUpModel signModel) {
		return signMapper.detailCount(signModel);
	}

	@Override
	public SignUpModel getSignByCode(String id_code, String create_time) {
		return signMapper.getSignByCode(id_code, create_time);
	}

	@Override
	public Integer updateEntiy(SignUpModel signModel) {
		return signMapper.updateEntiy(signModel);
	}

	@Override
	public List<Object> selectMonthCount() {
		return signMapper.selectMonthCount();
	}

	@Override
	public List<Object> selectDayCount(String date) {
		return signMapper.selectDayCount(date);
	}

	@Override
	public void initSignData() {
		signMapper.initSignData();
	}

	/**
	 * 考勤导出
	 */
	@Override
	public List<SignUpModel> exportForm(SignUpModel signUpModel) {
		List<SignUpModel> list=signMapper.exportForm(signUpModel);
		return list;
	}

	@Override
	public List<SignUpModel> countState(SignUpModel signUpModel) {
		List<SignUpModel> list=signMapper.countState(signUpModel);
		return list;
	}

}
