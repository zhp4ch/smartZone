package com.mass.biz.smart.adConfiguration.service.impl; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mass.biz.smart.adConfiguration.dao.AdConfigurationMapper;
import com.mass.biz.smart.adConfiguration.model.AdConfiguration;
import com.mass.biz.smart.adConfiguration.service.AdConfigurationService;

/**
 * 类描述：广告配置服务层
 * 创建人：yihai Zhao
 */
@Service
public class AdConfigurationServiceImpl implements AdConfigurationService {

	@Autowired
	private AdConfigurationMapper adConfigurationMapper;
	
	@Override
	public AdConfiguration addAdConfiguration(AdConfiguration adConfiguration) {
		return this.adConfigurationMapper.addAdConfiguration(adConfiguration)>0 ? adConfiguration : null;
	}

	@Override
	public boolean editAdConfiguration(AdConfiguration adConfiguration) {
		return 0<this.adConfigurationMapper.editAdConfiguration(adConfiguration);
	}

	@Override
	public List<AdConfiguration> selectList(AdConfiguration adConfiguration) {
		List<AdConfiguration> list = this.adConfigurationMapper.selectList(adConfiguration);
		return list;
	}

	@Override
	public boolean editAdConfByType(Integer type) {
		return 0<this.adConfigurationMapper.editAdConfByType(type);
	}

	@Override
	public boolean delAdConfiguration(Integer type) {
		return 0<this.adConfigurationMapper.delAdConfiguration(type);
	}

	@Override
	public AdConfiguration selectAdConfig(Integer state) {
		return this.adConfigurationMapper.selectAdConfig(state);
	}
}
