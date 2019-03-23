package com.mass.biz.smart.screen.service;

import com.mass.biz.smart.screen.model.Screen;
import com.mass.core.utils.AjaxResponse;

/**
 * 
 * @author zhping
 *
 */
public interface ScreenService {
	AjaxResponse update(Screen screen);
	AjaxResponse selectList();
	
	//持续修改销售数据
	AjaxResponse updateTimer();
	
	//初始化销售数据为32万多
	AjaxResponse initSaleNum();
}
