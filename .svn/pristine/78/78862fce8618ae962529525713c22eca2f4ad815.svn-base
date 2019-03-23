package com.mass.biz.smart.property.equipmentsInspection.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mass.biz.smart.property.equipmentsInspection.model.InspectionModel;
import com.mass.biz.smart.property.equipmentsInspection.service.InspectionService;
import com.mass.biz.smart.property.message.model.Message;
import com.mass.biz.smart.property.message.service.MessageService;
import com.mass.core.sys.file.model.FileInfoTemp;
import com.mass.core.sys.file.service.FileUploadService;
import com.mass.biz.smart.user.model.SzUser;
import com.mass.biz.smart.user.service.SzUserService;
import com.mass.core.sys.user.model.SysUser;
import com.mass.core.utils.AjaxResponse;
import com.mass.core.utils.ExportExcelUtil;
/**
 * 
* @Title: InspectionController.java
* @Package com.mass.biz.smart.property.equipmentsInspection.controller
* @Description: TODO(巡检控制层 sz_device_check)
* @author hq
* @date 2018年8月16日 下午12:47:12
* @Since jdk 1.8
* @version V1.0
 */

@RestController
@RequestMapping("/inspection")
public class InspectionController {
	private final static Logger LOGGER = LoggerFactory.getLogger(InspectionController.class);
	
	@Autowired InspectionService inspectionService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Value("${fileURL}")
    private String fileURL;
	
	@Autowired
	private MessageService messageService;
	
	
	@Autowired 
	private  SzUserService szUserService; 
	
	/**
	 * 
	 * @Title:selectinspectionList
	 * @Description:(分页条件查询)
	 * @return:AjaxResponse(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	@RequestMapping("/selectinspectionList")
	public AjaxResponse selectinspectionList(InspectionModel inspectionModel,
			@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			/*if(inspectionModel.getRid() == 0){
				
			}
		*/
			List<InspectionModel> list = this.inspectionService.selectinspectionList(inspectionModel,(pageIndex-1)*pageSize,pageSize);
			long count= this.inspectionService.count(inspectionModel);
			return AjaxResponse.success("selectinspectionList ok", list,count,pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("selectinspectionList error");
			return AjaxResponse.error("selectinspectionList error",inspectionModel);
		}
	}
	
	
	/**
	 * 
	 * @Title:updateInspection
	 * @Description:(修改)
	 * @return:AjaxResponse(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	@RequestMapping("/updateInspection")
	public AjaxResponse updateInspection(InspectionModel inspectionModel) {
		Integer data = inspectionService.updateInspection(inspectionModel);
		if (data != 1) {
			return AjaxResponse.error("no", data);
		} else {
			return AjaxResponse.success("ok", data);
		}
	}
	
	@RequestMapping("/selectUserList")
	public AjaxResponse selectUserList(InspectionModel inspectionModel,@RequestParam("page")Integer pageIndex,@RequestParam("limit")Integer pageSize){
		try {
			List<InspectionModel> list = this.inspectionService.selectUserList(inspectionModel, pageIndex-1, pageSize);
			Long count = this.inspectionService.userCount(inspectionModel);
			return AjaxResponse.success("selectUserList ok", list, count, pageIndex);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.error("selectUserList error");
		}
	}
	
	
	@RequestMapping("/addMendUser")
	public void addMendUser(InspectionModel inspectionModel){
		try {
			this.inspectionService.addMendUser(inspectionModel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/addMessage")
	public AjaxResponse addMessage(InspectionModel inspectionModel,HttpSession session){
		try {
			SysUser sysUser = (SysUser) session.getAttribute("sysUser");
			Message mes		= new Message();
			mes.setMsgContent(inspectionModel.getMsg());			//消息内容
			mes.setSendId(sysUser.getId());					//发送人id
			mes.setSendName(sysUser.getName());				//发送人名称
			mes.setUserId(inspectionModel.getRid());				//接收人id
			mes.setMsgState(6);								//消息类型1-推送商户信息类  2-合同到期提醒 3-新闻推送 4-物业费催收  5-管理员推送给监管人员  6-巡检派送意见  7-巡检人员推送给管理人
			mes.setStatus(3); 								//发送人身份识别 1-个人 2-商户 3-管理员
			mes.setReadFlag(0);								//阅读标记 -->0-未读 1-已读
			mes.setManyId(inspectionModel.getId()); 				//外键id
			messageService.addMessage(mes);
			return AjaxResponse.success("ok","");
		} catch (Exception e) {
			e.printStackTrace();
			return  new AjaxResponse("fail","","");
		}
	}
	/**
	* @Title: selectInsByYear 
	* @Description: 柱状图统计 
	* @param @param year
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月16日 下午7:39:25 
	* @version V1.0
	 */
	@RequestMapping("/selectInsByYear")
	public AjaxResponse selectInsByYear(@RequestParam("year")String year){
		try {
			List<InspectionModel> list = this.inspectionService.selectInsByYear(year);
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("01", 0);
			map.put("02", 0);
			map.put("03", 0);
			map.put("04", 0);
			map.put("05", 0);
			map.put("06", 0);
			map.put("07", 0);
			map.put("08", 0);
			map.put("09", 0);
			map.put("10", 0);
			map.put("11", 0);
			map.put("12", 0);
			for (int i = 0; i < list.size(); i++) {
				InspectionModel ins = list.get(i);
				if ("01".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("01", ins.getCount());
				}else if ("02".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("02", ins.getCount());
				}else if ("03".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("03", ins.getCount());
				}else if ("04".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("04", ins.getCount());
				}else if ("05".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("05", ins.getCount());
				}else if ("06".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("06", ins.getCount());
				}else if ("07".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("07", ins.getCount());
				}else if ("08".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("08", ins.getCount());
				}else if ("09".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("09", ins.getCount());
				}else if ("10".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("10", ins.getCount());
				}else if ("11".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("11", ins.getCount());
				}else if ("12".equals(ins.getMonth()) && ins.getCount()!=0) {
					map.put("12", ins.getCount());
				}
			}
			return AjaxResponse.success("selectInsByYear ok", map);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResponse.success("selectInsByYear error");
		}
	}
	/**
	* @Title: selectInsByEqu 
	* @Description: 饼状图
	* @param @param year
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月16日 下午7:41:02 
	* @version V1.0
	 */
	@RequestMapping("/selectInsByEqu")
	public AjaxResponse selectInsByEqu(@RequestParam("year")String year){
		List<InspectionModel> list = this.inspectionService.selectInsByEqu(year);
		return AjaxResponse.success("selectInsByEqu ok", list);
	}
	/**
	* @Title: addInspection 
	* @Description: 新增
	* @param @param inspectionModel
	* @param @return    入参
	* @return AjaxResponse    返回类型
	* @author yihai Zhao   
	* @throws
	* @date 2018年8月16日 下午9:10:10 
	* @version V1.0
	 */
	@RequestMapping("/addInspection")
	public AjaxResponse addInspection(InspectionModel inspectionModel,MultipartHttpServletRequest request,
    		String type, String code, boolean isShrink,HttpSession session){
			String filePath = "";
			List<FileInfoTemp> list = this.fileUploadService.uploadFile(request, code, isShrink);
			for (FileInfoTemp fileInfoTemp : list) {
				filePath += fileURL + fileInfoTemp.getRelativePath()+",";
			}
			inspectionModel.setCheckPic(filePath);
		 InspectionModel inspection = this.inspectionService.addInspection(inspectionModel);
		 return AjaxResponse.success("addInspection ok", inspection);
	}
	

	/**
	 * 
	 * @Title:selectInspectionById
	 * @Description:(根据id查询巡检记录)
	 * @return:AjaxResponse(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	@RequestMapping("/selectInspectionById")
	public AjaxResponse selectInspectionById(Long  id){
		InspectionModel	 inspectionModel = this.inspectionService.selectInspectionById(id);
		 return AjaxResponse.success("addInspection ok", inspectionModel);
	}
	
	
	@RequestMapping("/execlOut")	//导出的访问地址
	public void daoChuPersonnel(InspectionModel inspectionModel,HttpServletRequest request,
            HttpServletResponse response,HttpSession session,HSSFWorkbook hssfWorkbook,Integer pageIndex,Integer pageSize) throws Exception{
		List<InspectionModel> inspection = inspectionService.selectinspectionList(inspectionModel, 0, 999999);
		System.out.println("条数是"+inspection.size());
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		ExportExcelUtil eeu = new ExportExcelUtil(workbook, sheet);
		String[] strArr = new String[] { "序号","巡检人姓名","巡检时间", "巡检状况", "维护状态","设备编号", "设备名称(中文)","设备名称(英文)","设备管理人","设备管理人联系方式"};
		int colNum = strArr.length;
		int rowNO = 0;
		eeu.createExcelRow(workbook, sheet, rowNO, -1, colNum, "设备巡检基本信息表");
		rowNO++;
		
		eeu.createExcelRow(workbook,sheet,rowNO,350,colNum," "+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()), 200,"normal", "right");
		rowNO++;
		
		eeu.createColumnHeader(sheet, rowNO, 300, strArr);
		rowNO++;
		
		String[][] strings = new String[inspection.size()][11];
		for (int i = 0; i < inspection.size(); i++) {
			InspectionModel model = inspection.get(i);
			
			strings[i][0] = ""+(i+1);
			if(!ObjectUtils.isEmpty(model.getName())){
				strings[i][1] = model.getName();
			}else {
				strings[i][1] = "";
			}
			strings[i][2] = model.getCheckTime();
			if(model.getCheckState() == 0){
				strings[i][3] ="设备正常";
			}else if(model.getCheckState() == 1){
				strings[i][3] ="设备故障";
			}else{
				strings[i][3] ="";
			}
			
			if(model.getDealWith() == 0){
				strings[i][4]="正常";
			}else if(model.getDealWith() == 1){
				strings[i][4]="需维护";
			}else if(model.getDealWith() == 2){
				strings[i][4]="维护中";
			}else if(model.getDealWith() == 3){
				strings[i][4]="维护完成";
			}else {
				strings[i][4]="";
			}
			if(!ObjectUtils.isEmpty(model.getEquipments())){
				if(!ObjectUtils.isEmpty(model.getEquipments().getDeviceNo())){
					strings[i][5] = model.getEquipments().getDeviceNo();
				}else {
					strings[i][5] = "";
				}
				if(!ObjectUtils.isEmpty(model.getEquipments().getcDeviceName())){
					strings[i][6] = model.getEquipments().getcDeviceName();
				}else{
					strings[i][6] = "";
				}
				if(!ObjectUtils.isEmpty(model.getEquipments().geteDeviceName())){
					strings[i][7] = model.getEquipments().geteDeviceName();
				}else{
					strings[i][7] = "";
				}
				if(!ObjectUtils.isEmpty(model.getEquipments().getContact())){
					strings[i][8] = model.getEquipments().getContact();
				}else{
					strings[i][8] = "";
				}
				if(!ObjectUtils.isEmpty(model.getEquipments().getContactPhone())){
					strings[i][9] = model.getEquipments().getContactPhone();
				}else{
					strings[i][9]  = "";
				}
			}else{
				strings[i][4] = "";
				strings[i][5] = "";
				strings[i][6] = "";
				strings[i][7] = "";
				strings[i][8] = "";
				strings[i][9] = "";
			}
		}
		// sheet (创建sheet) rowNo 报表的单行行号(创建第几行) columnData 报表行中显示的数据
		// maxValue Excel显示的最大上限
		sheet = eeu.createColumnData(sheet, rowNO, strings, 65534);
		eeu.createSummaryRow(workbook, sheet, colNum, "总条数："
				+ strings.length, 200, "设备巡检基本信息表", "right");
		// 导出路径
		String fileName = "设备巡检基本信息表.xls";
		//下载
		this.downExcel(fileName, workbook, response);
	}
	/**
	* @Title: downExcel 
	* @Description: 下载到浏览器 
	* @param @param fileName
	* @param @param wb
	* @param @param response    入参
	* @return void    返回类型
	* @author huaqiang  
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
	
	@RequestMapping("/addMessagesWx")
	public AjaxResponse addMessagesWx(InspectionModel inspectionModel,HttpSession session){
		try {
			Message mes		= new Message();
			mes.setMsgContent("该设备需要维护，请派工处理！！！！");					// 默认 消息内容
			mes.setSendId(inspectionModel.getRid());						//发送人id
			mes.setSendName(inspectionModel.getName());						//发送人名称
			List<SzUser> szUser = szUserService.selectUserByType(10);
			for (SzUser szUser2 : szUser) {
				mes.setUserId(szUser2.getRid());							//接收人id
				mes.setMsgState(7);											//消息类型1-推送商户信息类  2-合同到期提醒 3-新闻推送 4-物业费催收  5-管理员推送给监管人员  6-巡检派送意见  7-巡检人员推送给管理人
				mes.setStatus(4); 											//发送人身份识别 1-个人 2-商户 3-管理员  4-物业
				mes.setReadFlag(0);											//阅读标记 -->0-未读 1-已读
				mes.setManyId(inspectionModel.getId()); 					//外键id
				messageService.addMessage(mes);
			}
			return AjaxResponse.success("ok","");
		} catch (Exception e) {
			e.printStackTrace();
			return  new AjaxResponse("fail","","");
		}
	}
	/**
	 * @Title:selectDisposeWx
	 * @Description:(我的处理查询)
	 * @return:AjaxResponse(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	/*@RequestMapping("/selectDisposeByUserIdWx")
	public AjaxResponse selectDisposeByUserIdWx(@RequestParam("userId")Long  userId){
		List<InspectionModel> list = this.inspectionService.selectDisposeByUserIdWx(userId);
		return AjaxResponse.success("selectDisposeByUserIdWx ok", list);
	}
	*/
	
	/**
	 * 
	 * @Title:selectUserByType
	 * @Description:(根据type查询用户)
	 * @return:AjaxResponse(返回类型)  
	 * @author:hq 
	 * @throws
	 */
	@RequestMapping("/selectUserByType")
	public AjaxResponse selectUserByType(@RequestParam("type")Integer  type){
		List<SzUser> szUser = szUserService.selectUserByType(type);
		return AjaxResponse.success("selectDisposeByUserIdWx ok", szUser);
	}
	
	
}
