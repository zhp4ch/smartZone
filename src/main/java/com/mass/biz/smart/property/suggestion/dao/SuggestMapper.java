package com.mass.biz.smart.property.suggestion.dao; 

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mass.biz.smart.property.suggestion.model.Suggest;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：SuggestMapper
 * 类描述：投诉建议dao
 * 创建人：yihai Zhao
 * 创建时间：2018年7月18日 下午2:26:37
 * 修改人：yihai Zhao
 * 修改时间：2018年7月18日 下午2:26:37
 * 
 * @version
 *
 */
@Mapper
public interface SuggestMapper {

	//新增
	int addSuggest(Suggest suggest);
	//修改
	int editSuggest(Suggest suggest);
	//删除
	int delSuggest(@Param("id")Long id);
	//详情
	Suggest getSuggestById(@Param("id")Long id);
	//count
	long count();
	//分页查询 -后台
	List<Suggest> selectPageList(@Param("suggest")Suggest suggest,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	//list查询-前台
	List<Suggest> selectSuggest();
	//统计整体情况 --按年统计每个月投诉条数
	List<Suggest> selectCountByYear(@Param("year")String year);
	//分类统计 --
	List<Suggest> selectContBySuggestCategory(@Param("year")String year);
	//派工处理=人员信息表完毕
	
	//查询自己的所有历史建议
	List<Suggest> selectHistory(@Param("rid")Long rid);
	
	//分页查询所有工作人员 
	List<Suggest> selectUserList(@Param("suggest")Suggest suggest,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);

	long userCount(@Param("suggest")Suggest suggest);

	void addMendUser(Suggest suggest);
	
	//浏览量自增
	int updateReadCount(@Param("id")Long id);
}
