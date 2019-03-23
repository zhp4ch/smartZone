package com.mass.biz.smart.user.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mass.biz.smart.user.dao.SzUserMapper;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;

@Service
public class SzUserServiceImpl implements SzUserService{
	
	
	String corpid = "ww24c1116a677d1bb0";
	String corpsecret = "A7DEVr2_pdUt6uWOr4jlpV9cwL1gXuWWQ5-alFCccFo";
	String  agentId = "1000002";
	
	@Autowired
	private SzUserMapper szUserMapper;

	@Override
	public List<SzUser> selectPageList(SzUser szUser, Integer pageIndex, Integer pageSize) {
		return szUserMapper.selectPageList(szUser, pageIndex, pageSize);
	}

	@Override
	public Long count(SzUser szUser) {
		return szUserMapper.count(szUser);
	}

	@Override
	public SzUser getEntityById(long rid) {
		return szUserMapper.getEntityById(rid);
	}

	@Override
	public SzUser insert(SzUser szUser) {
	   boolean b = 0 < this.szUserMapper.insert(szUser);
        return b ? szUser : null;
	}

	@Override
	public boolean delete(long rid,long delFlag) {
		return szUserMapper.delete(rid,delFlag)>0;
	}

	@Override
	public boolean update(SzUser szUser) {
		return szUserMapper.update(szUser)>0;
	}

	@Override
	public SzUser getEntityByOpendId(String openId) {
		return szUserMapper.getEntityByOpendId(openId);
	}

	@Override
	public Long countByIdCode(SzUser szUser) {
		return szUserMapper.countByIdCode(szUser);
	}

	@Override
	public int batchInsert(List<SzUser> szUserList) {
		return szUserMapper.batchInsert(szUserList);
	}

	@Override
	public int updateBatch(List<SzUser> list) {
		return szUserMapper.updateBatch(list);
	}

	@Override
	public List<SzUser> selectListByCondition(SzUser szUser) {
		return szUserMapper.selectListByCondition(szUser);
	}

	@Override
	public SzUser getEntityByIdCard(String id_code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validManager(SzUser szUser) {
		SzUser user =szUserMapper.validManager(szUser);
		if(user==null) {
			return false;
		}
		return true;
	}

	@Override
	public List<SzUser> selectUserByType(Integer type) {
		return szUserMapper.selectUserByType(type);
	}

	@Override
	public int updateByRid(SzUser szUser) {
		return szUserMapper.updateByRid(szUser);
	}

	@Override
	public int updateWhenNotMerchant(SzUser szUser) {
		return szUserMapper.updateWhenNotMerchant(szUser);
	}

	public String getAccess_token(){
	    	String turl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+corpsecret;
		       HttpClient client = new DefaultHttpClient();
		        HttpGet get = new HttpGet(turl);
		        String responseContent = null;
		        JSONObject obj = null;
			         try
			        {
			             HttpResponse res = client.execute(get);
		                 // 响应内容
			             HttpEntity entity = res.getEntity();
			             responseContent = EntityUtils.toString(entity, "UTF-8");
			             obj = JSON.parseObject(responseContent);
			         }
			       catch (Exception e)
			        {
			            e.printStackTrace();
			         }
		         finally
			        {
			            // 关闭连接 ,释放资源
			            client.getConnectionManager().shutdown();
			            return obj.getString("access_token");
		        }
	    }
	
	@Override
	public String sendWXMessage(String userId, String content) {
		   //参数userId就是openId，content是内容
	    	String token = this.getAccess_token();
	    	String response = sendWXMessageBody(token,userId,content);
	    		return response;
	}	    
	
    private  String sendWXMessageBody(String token,String userId,String content){
    	String uurl = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+token;
    	StringBuffer sb = null;
    	try {
            //创建连接
            URL url = new URL(uurl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            connection.connect();

            //POST请求
            DataOutputStream out = new DataOutputStream(
                    connection.getOutputStream());
            JSONObject obj = new JSONObject();
            JSONObject contentObj = new JSONObject();
            contentObj.put("content",content);
            obj.put("touser", userId);
            obj.put("msgtype","text");
            obj.put("agentid",agentId);
            obj.put("text", contentObj);
            System.out.println(obj.toJSONString());
            out.write(obj.toString().getBytes("UTF-8"));
            out.flush();
            out.close();

            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            
            reader.close();
            
            // 断开连接
            connection.disconnect();
           
          
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    	 return new String(sb);
    }

}
