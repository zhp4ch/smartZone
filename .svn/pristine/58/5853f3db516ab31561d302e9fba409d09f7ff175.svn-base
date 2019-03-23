package com.mass.biz.smart.property.propertyPriceStatistics.controller; 

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.property.message.model.Message;
import com.mass.biz.smart.property.message.service.MessageService;
import com.mass.biz.smart.property.propertyPriceStatistics.model.PropertyPrice;
import com.mass.biz.smart.property.propertyPriceStatistics.service.PropertyPriceService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.biz.utils.PayCommonUtil;
import com.mass.core.sys.file.service.FileUploadService;
import com.mass.core.utils.AjaxResponse;
import com.mass.core.utils.CusAccessObjectUtil;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：PropertyPriceController
 * 类描述：物业统计控制层
 * 创建人：zx
 * 创建时间：2018‎年‎8‎月‎8‎日 10:14:05
 * 
 * @version
 *
 */
@RestController
@RequestMapping("/wx/propertyPrice")
public class PropertyPriceWxController {

	@Autowired
	private PropertyPriceService propertyPriceService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private SzUserService szUserService;
	
	/**
	* @Title: getPropertyPriceByUserId
	* @Description: 用户物业费详情
	* @param @param userId
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018‎年‎8‎月‎10日 10:29:41
	 */
	@RequestMapping("/getPropertyPriceByUserId")
	public AjaxResponse getPropertyPriceByUserId(@RequestParam("userId")Long userId){
		try {
			List<PropertyPrice> pp = this.propertyPriceService.getPropertyPriceByUserId(userId);
			return AjaxResponse.success("ok ", pp);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	
	/**
	* @Title: getMerchantByUserId
	* @Description: 根据用户id查询公司信息
	* @param @param userId
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018‎年‎8‎月‎13日 16:30:02
	 */
	@RequestMapping("/getMerchantByUserId")
	public AjaxResponse getMerchantByUserId(@RequestParam("userId")Long userId){
		try {
			List<PropertyPrice> list = this.propertyPriceService.getMerchantByUserId(userId);
			return AjaxResponse.success("ok ", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	
	/**
	* @Title: queryPriceCountByuserId
	* @Description: 根据用户id查询应缴费时间前三天的数据
	* @param @param userId
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018‎年‎8‎月‎13日 16:30:02
	 */
	@RequestMapping("/queryPriceCountByuserId")
	public AjaxResponse queryPriceCountByuserId(@RequestParam("userId")Long userId){
		try {
			List<PropertyPrice> pp = this.propertyPriceService.queryPriceCountByuserId(userId);
			if(pp.size() > 0){
				for(PropertyPrice pro : pp){
					//新增消息推送
					Message msg	   = new Message();
					msg.setManyId(pro.getId()); 	//外键id
					msg.setUserId(pro.getUserId()); //接收人id
					msg.setSendId(Long.valueOf(1)); //发送人id
					msg.setSendName("admin");		//发送人姓名
					msg.setMsgState(4);				//消息类型 -->1-推送商户信息类  2-合同到期提醒 3-新闻推送 4-物业费催收 5- 管理员推送给监管人员
					msg.setMsgContent("请尽快缴费");	//消息内容
					msg.setStatus(3);				//用户身份识别  1-个人 2-商户 3-管理员
					msg.setReadFlag(0);				//阅读标记 0-未读 1-已读
					messageService.addMessage(msg);
					//修改本条物业费的推送状态
					pro.setIsCollection(1);
					propertyPriceService.editPropertyPrice(pro);
				}
			}
			return AjaxResponse.success("ok ", pp.size());
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	@RequestMapping("/selectPageList")
	public AjaxResponse selectPageList(PropertyPrice propertyPrice,@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			List<PropertyPrice> list = this.propertyPriceService.selectPageList(propertyPrice, pageIndex-1, pageSize);
			Long count = this.propertyPriceService.count(propertyPrice);
			return AjaxResponse.success("ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error");
		}
	}
	
	/**
	 * 物业交费下单接口
	 * @param propertyPrice
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/property/pay")
	public AjaxResponse valiManager( PropertyPrice propertyPrice, String type,HttpSession session,HttpServletRequest request) {
     	//获取订单编号
     	String orderNum = propertyPrice.getId().toString()+PayCommonUtil.getDateStr()+type;
     	//获取支付价钱
     	String total = propertyPrice.getTotal();
     	double d =Double.valueOf(total);	 
	   	BigDecimal a1 = new BigDecimal(Double.toString(d));
	   	BigDecimal b1 = new BigDecimal(Double.toString(100)); 
	   	BigDecimal result = a1.multiply(b1);// 相乘结果
	   	System.out.println(result);
     	//获取用户的openId
     	SzUser userEntity = szUserService.getEntityById(propertyPrice.getUserId());
     	String openId = userEntity.getOpid();
     	//String openId = "o_90J1Oe7tVxr8_J-3REgAo-JgqE";
    	Map<String,String> map = PayCommonUtil.weixinPrePay(orderNum, result.intValue(), "", CusAccessObjectUtil.getIpAddress(request),openId);
    	map.put("orderNum", orderNum);
    	return AjaxResponse.success("ok",map);
	}
	
	
	/**
	 * 微信支付异步回调
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/pay/notify")
	public String callBack(HttpServletRequest request,HttpServletResponse response){
		//System.out.println("微信支付成功,微信发送的callback信息,请注意修改订单信息");
		InputStream is = null;
		try {
			is = request.getInputStream();//获取请求的流信息(这里是微信发的xml格式所有只能使用流来读)
			String xml = PayCommonUtil.InputStream2String(is);
			Map<String, String> notifyMap = PayCommonUtil.doXMLParse(xml);
						
			if(notifyMap.get("return_code").equals("SUCCESS")){  
	                if(notifyMap.get("result_code").equals("SUCCESS")){  
	                String mch_id =  notifyMap.get("mch_id"); // 商户号
	                String ordersSn = notifyMap.get("out_trade_no");//商户订单号 
	                String amountpaid = notifyMap.get("total_fee");//实际支付的订单金额:单位 分
	                BigDecimal amountPay = (new BigDecimal(amountpaid).divide(new BigDecimal("100"))).setScale(2);//将分转换成元-实际支付金额:元
	                //String openid = notifyMap.get("openid");  //如果有需要可以获取
	                //String trade_type = notifyMap.get("trade_type");  
	                // 查询订单 根据订单号查询订单
	                String orderId = ordersSn.substring(0, ordersSn.length() - (PayCommonUtil.TIME.length()+1));
	                PropertyPrice  order = propertyPriceService.getPropertyPriceById(Long.parseLong(orderId));
	                //获取订单最后一个字符取type
	                String type = ordersSn.substring(ordersSn.length()-1,ordersSn.length());
	                // 验证商户ID 和 价格 以防止篡改金额
	             if (PayCommonUtil.MCH_ID.equals(mch_id) && order != null) {
	                if(type.trim().equals("1")) {
	                	//如果是物业费,验证物业费的价格和表中的是否一致
	                	BigDecimal propertyPrice = new BigDecimal(order.getPropertyCharge()) ;
	                	if(amountPay.compareTo(propertyPrice)==0) {
	                		  order.setPayState(2);
	                		  order.setReceiptNumber(ordersSn);
	                	}
	                }else {
	                	//水电费
	                	BigDecimal waterPrice = new BigDecimal(order.getHydropowerCharge()) ;
	                	if(amountPay.compareTo(waterPrice)==0) {
	                		 order.setWriterPayState(2);
              		  		 order.setWriterNumber(ordersSn);
	                	}
	                }
			                //修改订单状态
		  	              	 propertyPriceService.editPropertyPrice(order);
	                }
	                
	            /*    if (PayCommonUtil.MCH_ID.equals(mch_id) && order != null
	                 &&
	                 amountPay.toString().trim().equals(order.getTotal())
	                ) {
	                	  //物业费
	                	  if(type.trim().equals("1")) {
	                		  order.setPayState(2);
	                		  order.setReceiptNumber(ordersSn);
	                	 //水电费
	                	  }else {
	                		  order.setWriterPayState(2);
	                		  order.setWriterNumber(ordersSn);
	                	  }
	                	  //修改订单状态
	                	  propertyPriceService.editPropertyPrice(order);
	                }*/
	            }  
	        }
	        //告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
	        response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");  
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	/**
	* @Title: editPropertyPrice 
	* @Description: 物业统计修改
	* @param @param propertyPrice
	* @return AjaxResponse    返回类型
	* @author zx   
	* @throws
	* @date 2018‎年‎8‎月‎8‎日 11:20:23
	 */
	@RequestMapping("/editPropertyPrice")
	public AjaxResponse editPropertyPrice(PropertyPrice propertyPrice){
		try {
			return this.propertyPriceService.editPropertyPrice(propertyPrice)?AjaxResponse.success("ok", propertyPrice):AjaxResponse.error("error", propertyPrice);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("error", propertyPrice);
		}
	}
}
