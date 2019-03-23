package com.mass.biz.smart.property.propertyMend.controller; 

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mass.biz.smart.merchantScore.model.SzMerchantScore;
import com.mass.biz.smart.merchantScore.service.SzMerchantScoreService;
import com.mass.biz.smart.property.message.model.Message;
import com.mass.biz.smart.property.message.service.MessageService;
import com.mass.biz.smart.property.propertyMend.model.PropertyMend;
import com.mass.biz.smart.property.propertyMend.service.PropertyMendService;
import com.mass.core.sys.file.service.FileUploadService;
import com.mass.core.sys.user.model.SysUser;
import com.mass.core.utils.AjaxResponse;
import com.mass.core.utils.ExportExcelUtil;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：PropertyMendController
 * 类描述：物业报修控制层
 * 创建人：yihai Zhao
 * 创建时间：2018年8月6日 上午9:11:56
 * 修改人：yihai Zhao
 * 修改时间：2018年8月6日 上午9:11:56
 * 
 * @version
 *
 */
@RestController
@RequestMapping("/propertyMend")
public class PropertyMendController {

	@Autowired
	private PropertyMendService propertyMendService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Value("${fileURL}")
    private String fileURL;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired 
	private SzMerchantScoreService merchantScoreService;
	
	/**
	* @Title: addPropertyMend 
	* @Description: 物业报修新增 -微信端
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月6日 上午9:16:14 
	* @version V1.0
	 */
	@RequestMapping("/addPropertyMend")
	public AjaxResponse addPropertyMend(PropertyMend propertyMend){
		try {
			PropertyMend mend = this.propertyMendService.addPropertyMend(propertyMend);
			return AjaxResponse.success("addPropertyMend ok", mend);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("addPropertyMend error",propertyMend);
		}
	}
	/**
	* @Title: editPropertyMend 
	* @Description: 微信端：修改，反馈，评价  	 pc端：确认完工，派工处理
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月6日 上午9:19:42 
	* @version V1.0
	 */
	@RequestMapping("/editPropertyMend")
	@Transactional
	public AjaxResponse editPropertyMend(PropertyMend propertyMend){
		try {
			if(propertyMend.getState()!=null){
				if(propertyMend.getState()==2){
					//如果修改的时候，是确认完工 赋值完工时间
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String endTime = sdf.format(new Date());
						propertyMend.setEndTime(endTime);
						return this.propertyMendService.editPropertyMend(propertyMend)?AjaxResponse.success("editPropertyMend ok", propertyMend):AjaxResponse.error("editPropertyMend error", propertyMend);
					}
					if(propertyMend.getState()==3){
						//如果是商户自己反馈，并且没有超时，奖励积分,如果超时，扣除积分。
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String nowTime = sdf.format(new Date());
						//获取当前这条记录的完工时间，做判断
						PropertyMend mend = this.propertyMendService.getPropertyMendById(propertyMend.getId());
						String endTime = mend.getEndTime();
						//计算时间
						Date nowDate = sdf.parse(nowTime);
						Date endDate = sdf.parse(endTime);
						System.out.println(endDate.getTime()-nowDate.getTime()/(1000*60*60*24)<3);
						if((endDate.getTime()-nowDate.getTime()/(1000*60*60*24)<3)){
							//如果小于三天  加积分
							merchantScoreService.outsideInsert(mend.getRid(),SzMerchantScore.REPAIR_FEEDBACK_TIMELY_Y_TYPE);
						}else{
							//如果大于三天 减少积分
							merchantScoreService.outsideInsert(mend.getRid(), SzMerchantScore.REPAIR_FEEDBACK_TIMELY_N_TYPE);
						}
					}
					//如果是物业管理员来反馈的话，减少积分
					if(propertyMend.getState()==4){
						PropertyMend mend = this.propertyMendService.getPropertyMendById(propertyMend.getId());
						merchantScoreService.outsideInsert(mend.getRid(), SzMerchantScore.REPAIR_FEEDBACK_TIMELY_N_TYPE);
					}
			}
			return this.propertyMendService.editPropertyMend(propertyMend)?AjaxResponse.success("editPropertyMend ok", propertyMend):AjaxResponse.error("editPropertyMend error", propertyMend);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("editPropertyMend error", propertyMend);
		}
	}
	/**
	* @Title: delPropertyMend 
	* @Description: 逻辑删除
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月6日 上午9:24:46 
	* @version V1.0
	 */
	@RequestMapping("/delPropertyMend")
	public AjaxResponse delPropertyMend(@RequestParam("id")Long id){
		try {
			return this.propertyMendService.delPropertyMend(id)?AjaxResponse.success("delPropertyMend ok", id):AjaxResponse.error("delPropertyMend error", id);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("delPropertyMend error");
		}
	}
	/**
	* @Title: getPropertyMendById 
	* @Description: 详情
	* @param @param id
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月6日 上午9:24:58 
	* @version V1.0
	 */
	@RequestMapping("/getPropertyMendById")
	public AjaxResponse getPropertyMendById(@RequestParam("id")Long id){
		try {
			PropertyMend mend = this.propertyMendService.getPropertyMendById(id);
			return AjaxResponse.success("getPropertyMendById ok ", mend);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("getPropertyMendById error");
		}
	}
	@RequestMapping("/getPropertyMendByRid")
	public AjaxResponse getPropertyMendByRid(@RequestParam("rid")Long rid){
		try {
			List<PropertyMend> mend = this.propertyMendService.getPropertyMendByRid(rid);
			return AjaxResponse.success("getPropertyMendByRid ok", mend);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("getPropertyMendByRid error");
		}
	}
	/**
	* @Title: selectPageList 
	* @Description: 分页查询 
	* @param @param propertyMend
	* @param @param pageIndex
	* @param @param pageSize
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月6日 上午9:27:52 
	* @version V1.0
	 */
	@RequestMapping("/selectPageList")
	public AjaxResponse selectPageList(PropertyMend propertyMend,@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			List<PropertyMend> list = this.propertyMendService.selectPageList(propertyMend, pageIndex-1, pageSize);
			Long count = this.propertyMendService.count(propertyMend);
			return AjaxResponse.success("selectPageList ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("selectPageList error");
		}
	}
	/**
	* @Title: selectMendStart 
	* @Description: wx管理端-工作人员 待处理查询 
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月19日 下午4:21:14 
	* @version V1.0
	 */
	@RequestMapping("/selectMendStart")
	public AjaxResponse selectMendStart(PropertyMend propertyMend){
		try {
			List<PropertyMend> list = this.propertyMendService.selectMendStart(propertyMend);
			return AjaxResponse.success("selectMendStart ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("selectMendStart error");
		}
	}
	/**
	* @Title: selectMendEnd 
	* @Description: wx管理端-工作人员 查询已完成
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月19日 下午4:22:59 
	* @version V1.0
	 */
	@RequestMapping("/selectMendEnd")
	public AjaxResponse selectMendEnd(PropertyMend propertyMend){
		try {
			List<PropertyMend> list = this.propertyMendService.selectMendEnd(propertyMend);
			return AjaxResponse.success("selectMendEnd ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.success("selectMendEnd error");
		}
	}
	/**
	* @Title: selectAdminMendStart 
	* @Description: 微信管理员查询未完成
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月19日 下午6:36:55 
	* @version V1.0
	 */
	@RequestMapping("/selectAdminMendStart")
	public AjaxResponse selectAdminMendStart(PropertyMend propertyMend){
		try {
			List<PropertyMend> list = this.propertyMendService.selectAdminMendStart(propertyMend);
			return AjaxResponse.success("selectAdminMendStart ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("selectAdminMendStart error");
		}
	}
	/**
	* @Title: selectAdminMendEnd 
	* @Description: 微信管理端 管理人员查询已完成接口
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月19日 下午6:38:35 
	* @version V1.0
	 */
	@RequestMapping("/selectAdminMendEnd")
	public AjaxResponse selectAdminMendEnd(PropertyMend propertyMend){
		try {
			List<PropertyMend> list = this.propertyMendService.selectAdminMendEnd(propertyMend);
			return AjaxResponse.success("selectAdminMendEnd ok", list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("selectAdminMendEnd error");
		}
	}
	/**
	* @Title: exportprogest 
	* @Description: 导出物业报修表 
	* @param @param propertyMend
	* @param @param request
	* @param @param response
	* @param @param pageIndex
	* @param @param pageSize    入参
	* @return void    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月10日 下午3:19:55 
	* @version V1.0
	 */
	@RequestMapping("/exportPropertyMend")
	public void exportprogest(PropertyMend propertyMend,HttpServletRequest request, HttpServletResponse response,Integer pageIndex,Integer pageSize){
		List<PropertyMend> list = this.propertyMendService.selectPageList(propertyMend, 0, 99999999);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		ExportExcelUtil eeu = new ExportExcelUtil(workbook, sheet);
		String[] strArr = new String[] { "姓名","身份证号", "手机号", "报修地址", "报修类型","报修描述",
				"状态","评价","报修时间"};
		int colNum = strArr.length;
		int rowNO = 0;
		eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum, "物业报修信息表");
		rowNO++;
		
		eeu.createExcelRow(workbook,sheet,rowNO,350,colNum," "+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()), 200,"normal", "right");
		rowNO++;
		
		eeu.createColumnHeader(sheet, rowNO, 300, strArr);
		rowNO++;
		
		String[][] strings = new String[list.size()][9];
		for (int i = 0; i < list.size(); i++) {
			PropertyMend pro = list.get(i);
			strings[i][0] = pro.getName();
			strings[i][1] = pro.getIdCode();
			strings[i][2] = pro.getPhone();
			strings[i][3] = pro.getPropertyMendAddress();
			if (pro.getPropertyMendState()==0) {
				strings[i][4] = "水电";
			}else if (pro.getPropertyMendState()==1) {
				strings[i][4] = "煤气";
			}else if (pro.getPropertyMendState()==2) {
				strings[i][4] = "安防";
			}else if (pro.getPropertyMendState()==3) {
				strings[i][4] = "其他";
			}else{
				strings[i][4] = "未知";
			}
			strings[i][5] = pro.getPropertyMendContent();
			
			if(pro.getState()==0){
				strings[i][6] = "待处理";
			}else if(pro.getState()==1){
				strings[i][6] = "处理中";
			}else if(pro.getState()==2){
				strings[i][6] = "待反馈";
			}else if(pro.getState()==3 || pro.getState()==4){
				strings[i][6] = "待确认";
			}else if(pro.getState()==0){
				strings[i][6] = "已完成";
			}else{
				strings[i][6] = "未知";
			}
			strings[i][7] = pro.getEvaluate();
			strings[i][8] = pro.getCreateTime();
		}
		sheet = eeu.createColumnData(sheet, rowNO, strings, 65534);
		eeu.createSummaryRow(workbook, sheet, colNum, "总条数："
				+ strings.length, 200, "物业报修信息表", "right");
		// 导出路径
		String fileName = "物业报修信息表.xls";
		//下载
		this.downExcel(fileName, workbook, response);
	}
	/**
	 * 
	* @Title: downExcel 
	* @Description: 下载到浏览器 
	* @param @param fileName
	* @param @param wb
	* @param @param response    入参
	* @return void    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年7月20日 下午2:34:16 
	* @version V1.0
	 */
	private void downExcel(String fileName, Workbook wb,HttpServletResponse response) {
		OutputStream out = null;
		try {
			String headStr = new StringBuilder().append("attachment;fileName=")
					.append(URLEncoder.encode(fileName, "UTF-8")).toString();
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", headStr);
			out = response.getOutputStream();
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	* @Title: selectUserList 
	* @Description: 分页查询所有工作人员 
	* @param @param propertyMend
	* @param @param pageIndex
	* @param @param pageSize
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018年8月14日 15:32:51
	 */
	@RequestMapping("/selectUserList")
	public AjaxResponse selectUserList(PropertyMend propertyMend,@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			List<PropertyMend> list = this.propertyMendService.selectUserList(propertyMend, pageIndex-1, pageSize);
			Long count = this.propertyMendService.userCount(propertyMend);
			return AjaxResponse.success("selectUserList ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("selectUserList error");
		}
	}
	
	/**
	* @Title: addMendUser 
	* @Description: 新增派工人员
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018年8月14日 16:44:32
	 */
	@RequestMapping("/addMendUser")
	public void addMendUser(PropertyMend propertyMend){
		try {
			this.propertyMendService.addMendUser(propertyMend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* @Title: addMessage 
	* @Description: 新增消息推送
	* @param @param propertyMend
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author zx  
	* @throws
	* @date 2018年8月14日 20:21:32
	 */
	@RequestMapping("/addMessage")
	public AjaxResponse addMessage(PropertyMend propertyMend, HttpSession session){
		try {
			SysUser sysUser = (SysUser) session.getAttribute("sysUser");
			Message mes	=	new Message();
			mes.setMsgContent(propertyMend.getMsg());		//消息内容
			mes.setSendId(sysUser.getId());					//发送人id
			mes.setSendName(sysUser.getName());				//发送人名称
			mes.setUserId(propertyMend.getRid());			//接收人id
			mes.setMsgState(5);								//消息类型1-推送商户信息类  2-合同到期提醒 3-新闻推送 4-物业费催收 5- 管理员推送给监管人员
			mes.setStatus(3); 								//发送人身份识别 1-个人 2-商户 3-管理员
			mes.setReadFlag(0);								//阅读标记 -->0-未读 1-已读
			mes.setManyId(propertyMend.getId()); 			//外键id
			messageService.addMessage(mes);
			return AjaxResponse.success("ok","");
		} catch (Exception e) {
			e.printStackTrace();
			return  new AjaxResponse("fail","","");
		}
	}
}
