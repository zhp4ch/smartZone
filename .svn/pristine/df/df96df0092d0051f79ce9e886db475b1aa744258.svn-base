package com.mass.biz.utils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.mass.core.support.wxSupport.tenpay.util.MD5Util;


//caiyuan
public class PayCommonUtil {
		/*//appid
		public static String APPID = "wx6309eb8aef0ca434";*/
    	//appid
  /*      public static String APPID = "wx6309eb8aef0ca434";*/
        
        public static String APPID = "ww24c1116a677d1bb0";
        //apiKey
        public static String API_KEY = "G1617440B81E13FECBCBDED2adw2zxcv";
        //商家号
        public static String MCH_ID = "1498649632";
        
        public static final String TIME = "yyyyMMddHHmmss";
        
        public static final String url = "http://testmgrsrv.710hbzhkj.com";
        
        
	public static Map<String, String> weixinPrePay(String sn,int totalAmount,  
            String description, String ip,String openId) {  
        
		//统一下单接口参数初始化
        SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();
        //第三方应用所属小程序、公众号账号分配的appId，在微信操作后台的基本设置里可以取得
        parameterMap.put("appid", PayCommonUtil.APPID);
        //商户Id，需要开通微信认证，商户入住，在微信商户平台登录所使用的账号
        parameterMap.put("mch_id", PayCommonUtil.MCH_ID);
        //随机字符串，长度固定为32位
        parameterMap.put("nonce_str", PayCommonUtil.getRandomString(32));
        //商品描述  格式为“商户名称-商品内容描述”
        parameterMap.put("body", "才源软件-商城小程序解决方案");
        //第三方系统内自主生产的商品订单号，必须唯一，既已经支付过的订单，不可重复支付
        parameterMap.put("out_trade_no", sn);  
        //交易币种，选填，默认为人民币
        parameterMap.put("fee_type", "CNY");  
        //订单总金额，单位为分
        parameterMap.put("total_fee", totalAmount+""); 
        //客户端IP
        parameterMap.put("spbill_create_ip", ip);  
        //回调接口，既支付完成后，微信异步通知第三方系统后台的结果通知，格式为XML，回掉接口不可带参数，需要在公网上可以访问
        parameterMap.put("notify_url", url+"/tu/wx/propertyPrice/pay/notify");
        //交易形式，小程序固定为JSAPI，其他类型请参考微信API
        parameterMap.put("trade_type", "JSAPI"); 
        //用户openId，如果为小程序支付，必填
        parameterMap.put("openid", openId);
  
        //签名
        String sign = PayCommonUtil.createSign("UTF-8", parameterMap,API_KEY);  
        parameterMap.put("sign", sign);  
        
        //将参数集合转为XML
        String requestXML = PayCommonUtil.getRequestXml(parameterMap);  
        System.out.println(requestXML);  
        
        //起调统一下单接口
        String result = PayCommonUtil.httpsRequest(  
                "https://api.mch.weixin.qq.com/pay/unifiedorder", "POST",  
                requestXML);  
        System.out.println(result);  
        Map<String, String> map = null;  
        try {  
        	//回调数据格式为XML，需要进行解析
            map = PayCommonUtil.doXMLParse(result);
            
            //时间戳，前端调用支付接口参数之一
            long time = System.currentTimeMillis();
            map.put("timeStamp", String.valueOf(time));
            
            //回调再前面参数初始化
            SortedMap<String, Object> resMap = new TreeMap<String, Object>();
            resMap.put("appId", APPID);
            resMap.put("nonceStr", map.get("nonce_str"));
            //回调参数之一，内容为统一下单接口返回的prepay_id=*
            resMap.put("package", "prepay_id="+map.get("prepay_id"));
            map.put("package", "prepay_id="+map.get("prepay_id"));
            resMap.put("signType", "MD5");
            resMap.put("timeStamp", time);
//          resMap.put("key", API_KEY);
            //再签名
            String resign = PayCommonUtil.createSign("UTF-8", resMap, API_KEY);
            map.put("paySign", resign);
        } catch (JDOMException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return map;  
    }  

    //获取32位随机数
    public static String getRandomString(int length) {     
        String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    //生成请求的Xml 
    public static String getRequestXml(SortedMap<String, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(key) || "body".equalsIgnoreCase(key) || "sign".equalsIgnoreCase(key)) {
                sb.append("<" + key + ">" + "<![CDATA[" + value + "]]></" + key + ">");
            } else {
                sb.append("<" + key + ">" + value + "</" + key + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    //生成签名
    public static String createSign(String characterEncoding, SortedMap<String, Object> parameters, String apiKey) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + apiKey);
        System.out.println(sb.toString());
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    /**
     * 验证签名格式
     * @param packageParams
     * @param key
     * @param charset
     * @return
     */
    public static boolean isTenpaySign(Map<String, String> map, String apiKey) throws UnsupportedEncodingException {
        String charset = "utf-8";
        String signFromAPIResponse = map.get("sign");
        if (signFromAPIResponse == null || signFromAPIResponse.equals("")) {
            return false;
        }
        SortedMap<String, String> packageParams = new TreeMap<>();
        for (String parameter : map.keySet()) {
            String parameterValue = map.get(parameter);
            String v = "";
            if (null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }

        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + apiKey);

     
        String resultSign = "";
        String tobesign = sb.toString();
        if (null == charset || "".equals(charset)) {
            resultSign = MD5Util.MD5Encode(tobesign, charset).toUpperCase();
        } else {
            resultSign = MD5Util.MD5Encode(tobesign, charset).toUpperCase();
        }
        String tenpaySign = packageParams.get("sign").toUpperCase();
        return tenpaySign.equals(resultSign);
    }

    //起调统一下单接口
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        try {

            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            System.out.println(ce);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //xml解析
    public static Map doXMLParse(String strxml) throws  IOException, JDOMException {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

        if (null == strxml || "".equals(strxml)) {
            return null;
        }

        Map m = new HashMap();

        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if (children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = getChildrenText(children);
            }
        	System.out.println(k+"-"+v);
            m.put(k, v);
        }

        in.close();

        return m;
    }

    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }
    
    /**
     * 返回当前时间字符串
     * 
     * @return yyyyMMddHHmmss
     */
    public static String getDateStr()
    {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME);
        return sdf.format(new Date());
    }
    
    public static String InputStream2String(InputStream in) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(in, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}