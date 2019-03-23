package com.mass.biz.smart.user.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.core.utils.AjaxResponse;

/**
 * 客户端登录相关
 * @author jiangd
 */
@RestController
@RequestMapping("/wx/szUserLogon")
public class SzUserLogonController {
	
	
	//710测试服
	/*
	String appid = "wx6619f3998c458c50";
	String AppSecret = "ddcd244bc08fdd8714e8612d87f42b18";
	*/
	
	//caiyuan,以前为公众号的id和secret,现在升级为企业微信了，这个不用了
	/*String appid = "wx6309eb8aef0ca434";
	String AppSecret = "ea05d18a2424b29b9db2b9325ed8ae23";*/
	
	//企业微信cropid和secret
	String corpid = "ww24c1116a677d1bb0";
	String corpsecret = "A7DEVr2_pdUt6uWOr4jlpV9cwL1gXuWWQ5-alFCccFo";
	String  agentId = "1000002";
	@Autowired
	private SzUserService szUserService;
	
	
	/*@RequestMapping(value = "/getOpenId", method = RequestMethod.GET)
	public AjaxResponse getOpenId(@RequestParam("code") String code) {
		String turl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appid
				+ "&secret="
				+ AppSecret
				+ "&code="
				+ code
				+ "&grant_type=authorization_code";
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(turl);
		String responseContent = null;
		JSONObject obj = null;
		try {
			HttpResponse res = client.execute(get);
			// 响应内容
			HttpEntity entity = res.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
			obj = JSON.parseObject(responseContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接 ,释放资源
			client.getConnectionManager().shutdown();
			return AjaxResponse.success("ok", obj);
		}
	}*/
	
//	https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
/*	@RequestMapping(value = "/getAccess_token", method = RequestMethod.GET)
	public AjaxResponse getAccess_token() {
		String turl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ appid
				+ "&secret="
				+ AppSecret;
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(turl);
		String responseContent = null;
		JSONObject obj = null;
		try {
			HttpResponse res = client.execute(get);
			// 响应内容
			HttpEntity entity = res.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
			obj = JSON.parseObject(responseContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接 ,释放资源
			client.getConnectionManager().shutdown();
			return AjaxResponse.success("ok", obj);
		}
	}*/
	//获得access_token，根据公众号密钥交换（access_token一定时间内有效，因此可以在数据库缓存，避免频繁请求）
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
	
	  @RequestMapping("/getUserWXInfo")
	    public AjaxResponse getUserWXInfo(String code){
	    	JSONObject obj = null;
	    	String accessToken = this.getAccess_token();
	    	String userTicket = this.getUserTicket(accessToken, code);
	    	String responseContext = null;
	    	if(null !=userTicket&&!"".equals(userTicket)){
	    		responseContext = this.getUserInfoByTicket(userTicket, accessToken);
	    	}
	    	obj = JSON.parseObject(responseContext);
	    	return AjaxResponse.success("OK",responseContext);
	    }
	  
	    //以下微信相关接口
	    //获得userTicket 需要access_token以及前端授权跳转的code
	    public String getUserTicket(String token,String code){
	    	String turl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+token+"&code="+code;
	    	System.out.println(turl);	       
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
	    			             System.out.println(obj.toJSONString());
	    			         }
	    			       catch (Exception e)
	    			        {
	    			            e.printStackTrace();
	    			         }finally{
	    			        	 client.getConnectionManager().shutdown();
	    			             return obj.getString("user_ticket");
	    			         }
	    }
	  
	  
	  //利用usertickt交换用户信息
	    public String getUserInfoByTicket(String userTicket,String token){
	    	String uurl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserdetail?access_token="+token;
	    	System.out.println(uurl);
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
	            connection.setRequestProperty("contentType", "application/json");
	            connection.setRequestProperty("Charset", "UTF-8"); 
	            connection.connect();

	            //POST请求
	            DataOutputStream out = new DataOutputStream(
	                    connection.getOutputStream());
	            JSONObject obj = new JSONObject();
	            obj.put("user_ticket", userTicket);
	            out.writeBytes(obj.toString());
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
	    
	    @RequestMapping("/getOpenId")
	    public  AjaxResponse getOpenId(String wxuserid) throws Exception {
			// 设置参数
			String param = "{\"userid\":\"" + wxuserid + "\"}";
			String accessToken = this.getAccess_token();
			String urlPath = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token="+accessToken;
			// 建立连接
			URL url = new URL(urlPath);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setDoOutput(true); // 需要输出
			httpConn.setDoInput(true); // 需要输入
			httpConn.setUseCaches(false); // 不允许缓存
			httpConn.setRequestMethod("POST");
			// 设置请求属性
			httpConn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// 维持长连接
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("Charset", "UTF-8");
			// 连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
			httpConn.connect();
			// 建立输入流，向指向的URL传入参数
			httpConn.getOutputStream().write(param.getBytes());// 输入参数
			// 获得响应状态
			int resultCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == resultCode) {
				StringBuffer sb = new StringBuffer();
				String readLine = new String();
				BufferedReader responseReader = new BufferedReader(
						new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				System.out.println(sb.toString());
				return AjaxResponse.success("OK",sb.toString());
			}
			return AjaxResponse.success("error");
		}
	    
	    
	    @RequestMapping("/sendMessage")
	    public  AjaxResponse sendMessage(String userId,String type,String orderNum,String price) throws Exception {
	    	String typeStr = type.equals("1")?"物业费:":"水电费:";
	    	szUserService.sendWXMessage(userId,"您已成功支付"+typeStr+price+"元"+"\n"+"订单号为:"+orderNum);
			return AjaxResponse.success("ok");
		}

	
//	https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
/*	@RequestMapping(value = "/getWx_UserInfo", method = RequestMethod.GET)
	public AjaxResponse getWx_UserInfo(@RequestParam("access_token") String access_token,@RequestParam("open_id") String open_id) {
		String turl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
				+ access_token
				+ "&openid="
				+ open_id;
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(turl);
		String responseContent = null;
		JSONObject obj = null;
		try {
			HttpResponse res = client.execute(get);
			// 响应内容
			HttpEntity entity = res.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
			obj = JSON.parseObject(responseContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接 ,释放资源
			client.getConnectionManager().shutdown();
			return AjaxResponse.success("ok", obj);
		}
	}*/
	 
	   
}
