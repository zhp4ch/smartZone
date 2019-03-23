package com.mass.biz.smart.screen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.screen.dao.ScreenMapper;
import com.mass.biz.smart.screen.model.Screen;
import com.mass.biz.smart.screen.model.ScreenExample;
import com.mass.biz.smart.screen.service.ScreenService;
import com.mass.core.utils.AjaxResponse;
@Service
public class ScreenServiceImpl implements ScreenService {
	
	@Autowired
	private ScreenMapper screenMapper;

	@Override
	public AjaxResponse update(Screen screen) {
		return AjaxResponse.success(screenMapper.updateByPrimaryKeySelective(screen));
	}

	@Override
	public AjaxResponse selectList() {
		ScreenExample screenExample = new ScreenExample();
		
		return AjaxResponse.success(screenMapper.selectByExample(screenExample));
	}

	@Override
	public AjaxResponse updateTimer() {
		return AjaxResponse.success(screenMapper.updateTimer());
	}
	
	@Override
	public AjaxResponse initSaleNum() {
		return AjaxResponse.success(screenMapper.initSaleNum());
	}

}
