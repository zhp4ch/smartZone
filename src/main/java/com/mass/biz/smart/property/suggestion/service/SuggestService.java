package com.mass.biz.smart.property.suggestion.service; 

import java.util.List;

import com.mass.biz.smart.property.suggestion.model.Suggest;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：SuggestService
 * 类描述：投诉建议接口
 * 创建人：yihai Zhao
 * 创建时间：2018年7月18日 下午2:36:34
 * 修改人：yihai Zhao
 * 修改时间：2018年7月18日 下午2:36:34
 * 
 * @version
 *
 */
public interface SuggestService {
	
	Suggest addSuggest(Suggest suggest);
	
	boolean editSuggest(Suggest suggest);
	
	boolean delSuggest(Long id);
	
	Suggest getSuggestById(Long id);
	
	List<Suggest> selectPageList(Suggest suggest,Integer pageIndex,Integer pageSize);
	
	Long count();
	
	List<Suggest> selectSuggest();
	
	List<Suggest> selectCountByYear(String year);
	
	List<Suggest> selectContBySuggestCategory(String year);
	
	List<Suggest> selectHistory(Long rid);

	//分页查询所有工作人员 
	List<Suggest> selectUserList(Suggest suggest, int pageIndex,Integer pageSize);
	
	Long userCount(Suggest suggest);
	//新增派工数据
	void addMendUser(Suggest suggest);
}
