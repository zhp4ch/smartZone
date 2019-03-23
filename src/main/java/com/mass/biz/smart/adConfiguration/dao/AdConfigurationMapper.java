package com.mass.biz.smart.adConfiguration.dao; 

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.adConfiguration.model.AdConfiguration;
/**
 * 类描述：广告配置dao
 * 创建人：yihai Zhao
 */
@Mapper
public interface AdConfigurationMapper {

	//新增
	int addAdConfiguration(AdConfiguration adConfiguration);
	
	//修改
	int editAdConfiguration(AdConfiguration adConfiguration);
	
	//查询	根据type值不同，查询视频或者图片  视频单个 图片多张
	List<AdConfiguration> selectList(AdConfiguration adConfiguration);
	
	//删除
	int delAdConfiguration(@Param("type") Integer type);
	
	//设置播放
	int editAdConfByType(@Param("type")Integer type);
	
	//查询播放
	AdConfiguration selectAdConfig(@Param("state")Integer state);
}
