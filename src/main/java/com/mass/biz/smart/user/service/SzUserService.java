package com.mass.biz.smart.user.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.core.sys.file.model.FileInfoTemp;

public interface SzUserService {

	List<SzUser> selectPageList(SzUser szUser, Integer pageIndex, Integer pageSize);

	Long count(SzUser szUser);

	SzUser insert(SzUser szUser);

	boolean delete(long rid, long delFlag);

	boolean update(SzUser szUser);

	SzUser getEntityById(long rid);

	SzUser getEntityByOpendId(String openId);

	Long countByIdCode(SzUser szUser);

	int batchInsert(List<SzUser> szUserList);

	int updateBatch(List<SzUser> list);
	
	List<SzUser> selectListByCondition(SzUser szUser);
	
	SzUser getEntityByIdCard(String id_code);
	
	boolean validManager(SzUser szUser);

	//根据用户type查询用户rid
	List<SzUser> selectUserByType(Integer type);
	
    int updateByRid(SzUser szUser);
    
    int updateWhenNotMerchant(SzUser szUser);
    
    String sendWXMessage(String userId,String content);
    
    
 

}
