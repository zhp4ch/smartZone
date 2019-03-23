package com.mass.biz.smart.adConfiguration.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.adConfiguration.model.AdConfiguration;
import com.mass.biz.smart.adConfiguration.service.AdConfigurationService;
import com.mass.core.utils.AjaxResponse;

/**
 * 类描述：广告配置控制层
 * 创建人：yihai Zhao
 */
@RequestMapping("/adConf")
@RestController
public class AdConfigurationController {
	
	@Autowired
	private AdConfigurationService adConfigurationService;
	
	/**
	* @Description: 新增 
	* @author yihai Zhao
	 */
	@RequestMapping("/addAdConfiguration")
	public AjaxResponse addAdConfiguration(AdConfiguration adConfiguration){
		 AdConfiguration addAdConfiguration = this.adConfigurationService.addAdConfiguration(adConfiguration);
		 return	AjaxResponse.success("addAdConfiguration ok", addAdConfiguration);
	}
	/**
	* @Description: 修改
	* @author yihai Zhao
	 */
	@RequestMapping("/editAdConfiguration")
	@Transactional
	public AjaxResponse editAdConfiguration(AdConfiguration adConfiguration){
		if(adConfiguration.getState()!=null && adConfiguration.getType()==1){
			this.adConfigurationService.editAdConfByType(0);
		}else if(adConfiguration.getState()!=null && adConfiguration.getType()==0){
			this.adConfigurationService.editAdConfByType(1);
		}
		return this.adConfigurationService.editAdConfiguration(adConfiguration)?AjaxResponse.success("editAdConfiguration ok",adConfiguration):AjaxResponse.error("editAdConfiguration error",adConfiguration);
	}
	/**
	* @Description: 查询所有，根据type类型
	* @author yihai Zhao
	 */
	@RequestMapping("/selectList")
	public AjaxResponse selectList(AdConfiguration adConfiguration){
		List<AdConfiguration> list = this.adConfigurationService.selectList(adConfiguration);
		return AjaxResponse.success("selectList ok",list);
	}
	/**
	* @Description: 删除 
	* @author yihai Zhao
	 */
	@RequestMapping("/delAdConfiguration")
	public AjaxResponse delAdConfiguration(@RequestParam("type")Integer type){
		return this.adConfigurationService.delAdConfiguration(type)?AjaxResponse.success("del ok",type):AjaxResponse.error("del error",type);
	}
	/**
	* @Description: 查询设为播放的  参数传1即可。
	* @author yihai Zhao
	 */
	@RequestMapping("/selectAdConfig")
	public AjaxResponse selectAdConfig(@RequestParam("state") Integer state){
		AdConfiguration adConfig = this.adConfigurationService.selectAdConfig(state);
		return AjaxResponse.success("selectAdConfig ok",adConfig);
	}
}
