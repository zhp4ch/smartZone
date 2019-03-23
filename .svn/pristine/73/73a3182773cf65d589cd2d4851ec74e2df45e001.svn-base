package com.mass.biz.smart.screen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.screen.model.Screen;
import com.mass.biz.smart.screen.service.ScreenService;
import com.mass.core.utils.AjaxResponse;

@RestController
@RequestMapping("/screen")
public class ScreenController {
	@Autowired
	private ScreenService screenService;
	
	@RequestMapping("/update")
	public AjaxResponse update(Screen screen) {
		return screenService.update(screen);
	}
	@RequestMapping("/selectList")
	public AjaxResponse selectList() {
		return screenService.selectList();
	}
	
	/**
	 * 每5s执行一次
	 * 动态修改销售数据
	 * 修改范围在30以内
	 * @return
	 */
	@Scheduled(fixedRate=5000)
	@RequestMapping("/updateTimer")
	public AjaxResponse updateTimer() {
		return screenService.updateTimer();
	}
	
	/**
	 * 每天早上8点执行
	 * 初始化销售数据为32万多
	 * @return
	 */
	@Scheduled(cron="0 0 8 ? * *")
	public AjaxResponse initSaleNum() {
		return screenService.initSaleNum();
	}
}
